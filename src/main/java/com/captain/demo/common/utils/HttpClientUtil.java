/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.captain.demo.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    public static String httpPost(MediaType mediaType, URI uri, String requestContent) throws Exception {
        return httpPost(mediaType, uri, requestContent, null);
    }

    public static String httpPost(MediaType mediaType, String uri, String requestContent) throws Exception {
        return httpPost(mediaType, new URI(uri), requestContent, null);
    }

    public static String httpPost(MediaType mediaType, String uri, String requestContent, Integer timeOut) throws Exception {
        return httpPost(mediaType, new URI(uri), requestContent, timeOut);
    }

    public static String httpPost(MediaType mediaType, URI uri, String requestContent, Integer timeOut) throws Exception {
        HttpPost post = new HttpPost(uri);
        post.setHeader("Connection", "close");
        if (StringUtils.isNotBlank(mediaType.toString())) {
            post.setHeader(HttpHeaders.CONTENT_TYPE, mediaType.toString());
        }
        if (timeOut != null) {
            post.setConfig(RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut).build());
        }
        post.setEntity(new StringEntity(requestContent, Consts.UTF_8));
        return httpRequest(post);
    }

    public static String httpPost(String uri, Map<String, String> paramMap) throws Exception {
        return httpPost(new URI(uri), paramMap, 8000000);
    }

    public static String httpPost(URI uri, Map<String, String> paramMap) throws Exception {
        return httpPost(uri, paramMap, null);
    }

    public static String httpPost(String uri, Map<String, String> paramMap, Integer timeOut) throws Exception {
        return httpPost(new URI(uri), paramMap, timeOut);
    }

    public static String httpPost(URI uri, Map<String, String> paramMap, Integer timeOut) throws Exception {
        HttpPost post = new HttpPost(uri);
        post.setHeader("Connection", "close");
        if (timeOut != null) {
            post.setConfig(RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut).build());
        }
        List<BasicNameValuePair> list = map2NameValuePairList(paramMap);
        if (list != null && !list.isEmpty()) {
            post.setEntity(new UrlEncodedFormEntity(list, Consts.UTF_8));
        }
        return httpRequest(post);
    }

    public static String httpGet(URI uri, Map<String, String> paramMap) throws Exception {
        return httpGet(uri.toString(), paramMap, null);
    }

    public static String httpGet(URI uri, Map<String, String> paramMap, Integer timeOut) throws Exception {
        return httpGet(uri.toString(), paramMap, timeOut);
    }
    public static String httpGet(String uri, Map<String, String> paramMap) throws Exception {
        return httpGet(uri, paramMap, null);
    }

    public static String httpGet(String uri, Map<String, String> paramMap, Integer timeOut) throws Exception {
        HttpGet get = new HttpGet(uri);
        if (timeOut != null) {
            get.setConfig(RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut).build());
        }
        List<BasicNameValuePair> list = map2NameValuePairList(paramMap);
        if (list != null && !list.isEmpty()) {
            String requestParam = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            get.setURI(new URI(uri + "?" + requestParam));
        }
        return httpRequest(get);
    }

    private static String httpRequest(HttpRequestBase request) throws Exception {
        String reponseStr = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity resEntity = response.getEntity();
            reponseStr = EntityUtils.toString(resEntity, Consts.UTF_8);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                }
            }
        }
        return reponseStr;
    }

    private static List<BasicNameValuePair> map2NameValuePairList(Map<String, String> paramMap) {
        if (paramMap == null) {
            return null;
        }
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        Iterator<String> it = paramMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            list.add(new BasicNameValuePair(key, (String) paramMap.get(key)));
        }
        return list;
    }

    public static String PostWithJsonBody(String url, String reqestBody) throws Exception {
        String responseStr = "";
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(reqestBody, "UTF-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(entity);
            response = client.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            responseStr = EntityUtils.toString(responseEntity, "UTF-8");
        } finally {
            if (client != null) {
                client.close();
            }
            if (response != null) {
                response.close();
            }
        }
        return responseStr;
    }
}


