package com.marublo.feelcycle.service;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
	private String userIdFeelcycle ="";
	private String userPassFeelcycle ="";
	private String accessUrl = "";
	
	ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

	
	HtmlGetService(){
		this.requestConfig = RequestConfig.custom()
	             .setConnectTimeout(CONNECTION_TIMEOUT)
	             .setSocketTimeout(SOCKET_TIMEOUT)
	             .build();
		this.headers.add(new BasicHeader("Accept-Charset","utf-8"));
		this.headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));

		this.httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers).build();	
	}
	
	//ユーザーIDを返します
	public String getUserId(){
		return this.userIdFeelcycle;
	}

	public void gethtmlInit(String userIdFeelcycle, String userPassFeelcycle) throws IOException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		  // configurations
		this.userIdFeelcycle = userIdFeelcycle;
		this.userPassFeelcycle = userPassFeelcycle;
		this.FS_COOKIE = FeelCycleUtil.getFsCookie(this.userIdFeelcycle,this.userPassFeelcycle);
	    params.add(new BasicNameValuePair("login_id",this.userIdFeelcycle));
	    params.add(new BasicNameValuePair("login_pass", this.userPassFeelcycle));
	    params.add(new BasicNameValuePair("commit_login", ""));
	    params.add(new BasicNameValuePair("FS_Cookie", this.FS_COOKIE ));


	}

	public String gethtml(String pageName) throws ParseException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(pageName){
			case "MyPage":
				this.accessUrl = "https://www.feelcycle.com/feelcycle_reserve/mypage.php";
				break;
			 default:
				this.accessUrl = "";
				break;
		}
		this.post = new HttpPost(this.accessUrl);
	    this.post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	    this.response = this.httpClient.execute(this.post);
		
		return EntityUtils.toString(this.response.getEntity(),"UTF-8");
		
	}




}