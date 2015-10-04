/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.marublo.feelcycle.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.xpath.XPathExpressionException;


import org.apache.http.ParseException;

import org.apache.http.client.config.RequestConfig;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.marublo.feelcycle.dto.LessonDataDto;
import com.marublo.feelcycle.entity.Lessson;
import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.entity.UserDetail;
import com.marublo.feelcycle.entity.UserFeelcycle;
import com.marublo.feelcycle.form.ApiRegistForm;
import com.marublo.feelcycle.service.FeelcycleService;
import com.marublo.feelcycle.service.LesssonService;
import com.marublo.feelcycle.service.UserDetailService;
import com.marublo.feelcycle.service.UserFeelcycleService;
import com.marublo.feelcycle.service.UserService;





public class ApiRegistAction {
	
	
	/*
	 * FEEL CYCLEの受講データを取得するバッチ処理
	 * 動作させる時はjenkinsから curlコマンドで起動させる予定
	 * 
	 * 
	 */
	
	/*************DI*******************/
	@Resource
	public UserService userService;
	
	@Resource
	public UserFeelcycleService userFeelcycleService;
	
	
	@Resource
	public LesssonService lesssonService;

	
	@Resource
	public UserDetailService userDetailService;
	
	/*************DI*******************/
	
	/*************プロパティ*******************/
	public List<User> userList;
	public String unko = "";
	public String loginId = "";
	public String loginPass = "";
	public String nickName = "";
	public String feelcycleLoginId1 = "";
	public String feelcycleLoginPass1 = "";
	public String feelcycleLoginId2 = "";
	public String feelcycleLoginPass2 = "";
	public String json = "";
	
	public String resultMessage = "registResult:false";
	public List<Lessson> resultList;
	
	public RequestConfig requestConfig;
	
    @Execute(validator = false, urlPattern = "{loginId}/{loginPass}/{nickName}/{feelcycleLoginId1}/{feelcycleLoginPass1}/{feelcycleLoginId2}/{feelcycleLoginPass2}")
	public String index() {
    	//FA用のユーザー登録
    	User user = new User();
    	user.userId = loginId;
    	
    	//FeelAnalyticsのパスワード登録に関しては暗号化をする
    	String hashPass = userService.getSaltedPassword(loginPass,loginId);
    	user.userPass = hashPass;
    	
    	
    	UserDetail userDetail = new UserDetail();
    	userDetail.userId = loginId;
    	

    	
    	userDetail.nickName = nickName;
  
    	//feelcycle登録
    	UserFeelcycle userFc1 = new UserFeelcycle();
    	userFc1.userId = loginId;
    	userFc1.userIdFeelcycle = feelcycleLoginId1;
    	userFc1.userPassFeelcycle = feelcycleLoginPass1;

    	UserFeelcycle userFc2 = new UserFeelcycle();
    	//FC2に値が入ってた場合こちらも登録する
    	if ( feelcycleLoginId2 != null && feelcycleLoginId2.length() > 0 ){
    		userFc2.userId = loginId;
    		userFc2.userIdFeelcycle = feelcycleLoginId2;
    		userFc2.userPassFeelcycle = feelcycleLoginPass2;
    	}
    	
    	if ( feelcycleLoginId2 != null && feelcycleLoginId2.length() > 0 ){
    		if(userService.registUser(user) && userFeelcycleService.registUser(userFc1) &&
    				userFeelcycleService.registUser(userFc2) && userDetailService.registUser(userDetail)){
    			resultMessage = "registResult=true";
    		}else{
    			resultMessage = "registResult=false";
    		}
    	}else{
    		if(userService.registUser(user) && userFeelcycleService.registUser(userFc1) && userDetailService.registUser(userDetail)){
    			resultMessage = "registResult=true";
    		}else{
    			resultMessage = "registResult=false";
    		}
    	}
    	
    
    	return "index.jsp";
	}
    
    @Execute(validator = false)
    public String regist(){
    	
    	return "regist.jsp";
    }
    //ログイン情報を返すAPI
    @Execute(validator = false)
    public String checkUser(){
    	
    	boolean result = userService.getSelectUser(loginId,loginPass);
    	
    	if(result){
    		resultMessage = "true";
    	}else{
    		resultMessage = "false";
    	}
    	
    	if(loginId.equals("") || loginPass.equals("")){
    		resultMessage = "false";
    	}
    	
    	return "check.jsp";
    }
    
    
    //ログイン情報を返すAPI
    @Execute(validator = false)
    public String getLesson(){
    	
    	Lessson lessson = new Lessson();
    	lessson.userId = loginId;
    	json = "";
    	resultList = new ArrayList<Lessson>();
    	resultList = lesssonService.getLessonData(lessson);
    	
    	//jsonで文字列返す
    	
    	json = json + "{"
        			+ "\"lesson\":[";
    	
    	for(int i=0;i < resultList.size(); i++){
    		json = json + "{ \"lessonDate\":\"" + resultList.get(i).lessonDate +"\","
    					+   "\"lessonTimeFrom\":\"" + resultList.get(i).lessonTimeFrom + "\","
    					+   "\"lessonTimeTo\":\""   + resultList.get(i).lessonTimeTo + "\","
    					+	"\"lessonName\":\""     + resultList.get(i).lessonName + "\","
    					+   "\"instructor\":\""     + resultList.get(i).instructor + "\","
    					+   "\"lessonTenpo\":\""    + resultList.get(i).lessonTenpo + "\","
    					+   "\"lessonMashine\":\""  + resultList.get(i).lessonMashine + "\""
    					+ "}";
    		if(i != resultList.size()-1){
    			json = json + ",";
    			
    		}else{
    			json = json +"]"
    						+ "}";
    		}

    		
    	}

		return "lesson.jsp";
    }
 
    
}
