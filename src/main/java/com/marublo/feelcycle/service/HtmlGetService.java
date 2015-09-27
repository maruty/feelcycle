package com.marublo.feelcycle.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.seasar.extension.jdbc.JdbcManager;

import com.marublo.feelcycle.entity.User;



/**
 * {@link User}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class HtmlGetService{
	
	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	/*************DI*******************/

	
	
    private final int SOCKET_TIMEOUT = 4300;
    private final int CONNECTION_TIMEOUT =  4300;
    private final String USER_AGENT = "feel de yaseru";
	private RequestConfig requestConfig;
	private List<Header> headers = new ArrayList<Header>();
	private HttpClient httpClient;
	private HttpPost post;
	private String FS_COOKIE = "";
	private HttpResponse response ;
	
	HtmlGetService(){
		
	}

	public void gethtmlInit(String userIdFeelcycle, String userPassFeelcycle) {
		// TODO 自動生成されたメソッド・スタブ
		  // configurations

		
	}




}