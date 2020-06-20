/**
 * pxys
 * Copyright (C) 2017-2019 All Rights Reserved.
 */
package com.captain.demo.common.constant;/**
 * Created by pigun on 2019/8/26.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: XcxConst
 * @Description:
 * @Author: Monta
 * @Date: 2019/8/26 上午11:58
 **/
@Component
public class XcxConst {
	
	
	private static String appid;
	private static String secret;
	private static String serverName;
	
	@Value("${appid}")
	private void setAppid(String appid) {
		XcxConst.appid = appid;
	}
	@Value("${secret}")
	public void setSecret(String secret) {
		XcxConst.secret = secret;
	}
	@Value("${spring.application.name}")
	public void setServerName(String serverName) {
		XcxConst.serverName = serverName;
	}
	
	public static String APPID;
	  public static String SECRET;
	  public static String SESSION_KEY_PREFIX;
	  public static String URL_CODE2SESSION;
	  public static String ACCESS_TOKEN_URL;
	  public static String WECHAT_ACCESS_TOKEN_URL;
	  public static String TEMPLATE_MESSAGE_URL;
	  public static String TICKET_TO_CODE_URL;
	
	@PostConstruct
	public void init() {
		APPID = appid;
		SECRET = secret;
		SESSION_KEY_PREFIX = serverName+"_session_key_";
		URL_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code=JSCODE&grant_type=authorization_code";
		ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+SECRET;
		TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
		TICKET_TO_CODE_URL = "https://api.weixin.qq.com/intp/marketcode/tickettocode?access_token=ACCESSTOKEN";
		WECHAT_ACCESS_TOKEN_URL = "https://wx-test.xdp8.cn/wechat/getWxAccessToken/wx4c4a387f3bb2cf58";
	}
	
	
	

  
//
//    public static final String APPID = "wx7cc1b840135961dc";
//    public static final String SECRET = "5bc1def10e164c53ba7ab4e341259203";
//    public static final String SESSION_KEY_PREFIX = "dp_welfare_session_key_";
//
//    public static final String URL_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code=JSCODE&grant_type=authorization_code";
}