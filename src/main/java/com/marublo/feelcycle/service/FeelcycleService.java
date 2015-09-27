package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.User;


import java.io.IOException;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;




/**
 * {@link User}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class FeelcycleService{
	
	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	
	
	public HtmlGetService htmlGetService;
	/*************DI *******************/
	
	
	public String getPage(String pageParam) throws IOException{
		return pageParam;
	}
	
	
	public String getPage(String userIdFeelcycle, String userPassFeelcycle) throws IOException {
		//HtmlGetService htmlGetService = new HtmlGetService();
		htmlGetService.gethtmlInit(userIdFeelcycle,userPassFeelcycle);
		//htmlGetService.gethtml("MyPage");
		//parseLessonData(htmlGetService.executeGetHtml());

		return null;
	}

	private String parseLessonData(String executeGetHtml) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}





}