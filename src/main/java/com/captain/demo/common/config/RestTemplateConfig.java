package com.captain.demo.common.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Configuration
public class RestTemplateConfig {
	//Determines the timeout in milliseconds until a  connection is established.
	private static final int CONNECT_TIMEOUT = 30000;

	//The  timeout when requesting a connection from the connection manager.
	private static final int REQUEST_TIMEOUT = 30000;

	//The timeout for waiting for data
	private static final int SOCKET_TIMEOUT = 60000;

	private static final int MAX_TOTAL_CONNECTIONS = 50;
	private static final int DEFAULT_KEEP_ALIVE_TIME_MIlLIS = 20 * 1000;
	private static final int CLOSE_IDLE_CONNECTION_WAIT_TIME_SECS = 30;

	@Bean
	public RestTemplate restTemplate () {

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestfactory());

		/**
		 * StringHttpMessogeConverter 默认使用 IS0-8859-编码，此处修改为 UTF-8
		 */
		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
		while (iterator.hasNext()) {
			HttpMessageConverter<?> converter = iterator.next();
			if (converter instanceof StringHttpMessageConverter) {
				((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
			}
		}
		return restTemplate;
	}

	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestfactory () {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =  new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient());
		return clientHttpRequestFactory;
	}

	@Bean
	public PoolingHttpClientConnectionManager poolingConnectionManager() {

		SSLContextBuilder builder = new SSLContextBuilder();
		try {
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		}catch (NoSuchAlgorithmException | KeyStoreException e) {
			log.error ("Pooling Connection Manager Initialisation failure because of"+ e.getMessage(), e);
		}
		SSLConnectionSocketFactory sslsf = null;
		try{
			sslsf = new SSLConnectionSocketFactory (builder.build());
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			log.error("Pooling Connection Manager Initialisation failure because of" + e.getMessage(), e);
		}
		Registry socketFactoryRegistry = RegistryBuilder.create().register("https",sslsf).register("http",new PlainConnectionSocketFactory()).build();
//        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
//                .create ().register ("https", sslsf)
//                .register ( "http", new PlainConnectionSocketFactory())
//                .build ();

		PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager  (socketFactoryRegistry);
		poolingConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		return poolingConnectionManager;
	}

	@Bean
	public ConnectionKeepAliveStrategy connectionKeepAliveStrategy () {
		return new ConnectionKeepAliveStrategy (){

			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				HeaderElementIterator it = new BasicHeaderElementIterator
						(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						return Long.parseLong(value) * 1000;
					}
				}
				return DEFAULT_KEEP_ALIVE_TIME_MIlLIS;
			}


		};
	}


	@Bean
	public CloseableHttpClient httpClient() {
		RequestConfig requestConfig = RequestConfig.custom ()
				.setConnectionRequestTimeout(REQUEST_TIMEOUT)
				.setConnectTimeout (CONNECT_TIMEOUT)
				.setSocketTimeout (SOCKET_TIMEOUT).build();

		return HttpClients.custom ()
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager (poolingConnectionManager ())
				.setKeepAliveStrategy (connectionKeepAliveStrategy ())
				.build ();
	}
}
