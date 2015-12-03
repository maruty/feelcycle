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


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.marublo.feelcycle.dto.ShukeiDataDto;
import com.marublo.feelcycle.entity.Lessson;
import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.entity.UserDetail;
import com.marublo.feelcycle.entity.UserFeelcycle;
import com.marublo.feelcycle.form.ApiRegistForm;
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
	@ActionForm
	@Resource
	public ApiRegistForm apiRegistForm;
	
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

	public String resultMessage = "registResult:false";
	public String json = "";
	
    @Execute(validator = false)
	public String index() {
    	//FA用のユーザー登録
    	User user = new User();
    	user.userId = apiRegistForm.loginId;
    	
    	//FeelAnalyticsのパスワード登録に関しては暗号化をする
    	String hashPass = userService.getSaltedPassword(apiRegistForm.loginPass,apiRegistForm.loginId);
    	user.userPass = hashPass;
    	
    	UserDetail userDetail = new UserDetail();
    	userDetail.userId = apiRegistForm.loginId;
    	userDetail.nickName = apiRegistForm.nickName;

    	//feelcycle登録
    	UserFeelcycle userFc1 = new UserFeelcycle();
    	userFc1.userId = apiRegistForm.loginId;
    	userFc1.userIdFeelcycle = apiRegistForm.feelcycleLoginId1;
    	userFc1.userPassFeelcycle = apiRegistForm.feelcycleLoginPass1;

    	UserFeelcycle userFc2 = new UserFeelcycle();
    	//FC2に値が入ってた場合こちらも登録する
    	if ( apiRegistForm.feelcycleLoginId2 != null && apiRegistForm.feelcycleLoginId2.length() > 0 ){
    		userFc2.userId = apiRegistForm.loginId;
    		userFc2.userIdFeelcycle = apiRegistForm.feelcycleLoginId2;
    		userFc2.userPassFeelcycle = apiRegistForm.feelcycleLoginPass2;
    	}
    	//登録がちゃんとできているかの判定処理
    	if ( apiRegistForm.feelcycleLoginId2 != null && apiRegistForm.feelcycleLoginId2.length() > 0 ){
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
    

    //ログイン情報を返すAPI
    @Execute(validator = false)
    public String checkUser(){
    	
    	boolean result = userService.getSelectUser(apiRegistForm.loginId,apiRegistForm.loginPass);
    	
    	if(result){
    		resultMessage = "true";
    	}else{
    		resultMessage = "false";
    	}
    	
    	if(apiRegistForm.loginId.equals("") || apiRegistForm.loginPass.equals("")){
    		resultMessage = "false";
    	}
    	
    	return "check.jsp";
    }
    
    //ログイン情報を返すAPI
    @Execute(validator = false)
    public String UserData(){
    	
    	User user = new User();
    	user.userId = apiRegistForm.loginId;
    	user.userPass = apiRegistForm.loginPass;
    	
    	
    	
    	List<User> userResult = new ArrayList<User>();
    	//userList = new ArrayList<User>();
    	
    	
    	userResult = userService.getUser(user);
    	
    	json = "";
    	json = json + "{\"userId\":\"" +  userResult.get(0).userId +"\","
    				+   "\"userNickName\":\"" +  userResult.get(0).userDetail.nickName +"\"}";

    	//いったん共通化をlesson.jspで処理する（微妙）
    	//System.out.println("");
    	return "user.jsp";
    }
    
    
    //ログイン情報を返すAPI（レッスン情報）
    @Execute(validator = false)
    public String Lesson(){
    	
    	Lessson lessson = new Lessson();
    	lessson.userId = apiRegistForm.loginId;
    	
    	List<Lessson>resultList = new ArrayList<Lessson>();
    	resultList = lesssonService.getLessonData(lessson);
    	
    	//jsonで文字列返す
    	
    	json = json + ""
        			+ "[";
    	
    	for(int i=0; i < resultList.size(); i++){
    		json = json + "{\"lessonDate\":\"" + resultList.get(i).lessonDate +"\","
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
    						+ "";
    		}

    		
    	}

		return "lesson.jsp";
    }
    
    //ログイン情報を返すAPI（月のレッスン情報）
    @Execute(validator = false)
    public String LessonMonthlyData(){
    	Lessson lessson = new Lessson();
    	lessson.userId = apiRegistForm.loginId;
    	
    	List<Lessson>resultList = new ArrayList<Lessson>();
    	resultList = lesssonService.getLessonDataMonthly(lessson);
    	
    	//jsonで文字列返す
    	
    	json = json + ""
        			+ "[";
    	
    	for(int i=0; i < resultList.size(); i++){
    		json = json + "{\"lessonDate\":\"" + resultList.get(i).lessonDate +"\","
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
    						+ "";
    		}

    		
    	}
    	return "lesson.jsp";
    }
    
    //ログイン情報を返すAPI（集計関数インクルード）
    @Execute(validator = false)
    public String shukeiData(){
    	
    	Lessson lessson = new Lessson();
    	lessson.userId = apiRegistForm.loginId;
    	List<ShukeiDataDto> shukeiList = new ArrayList<>();
    	List<String> shukeiMaxDataList = new ArrayList<>();
    	
    	
    	//リストに詰める（一番受講しているレッスン)
    	ShukeiDataDto shukeiDataDto = new ShukeiDataDto();
    	shukeiMaxDataList = lesssonService.shukeiData(lessson);
    	shukeiDataDto.setShukeiName("MaxLessoname");
    	shukeiDataDto.setShukeiValue(shukeiMaxDataList.get(0));
    	shukeiList.add(shukeiDataDto);
    	
    	//リストに詰める（一番受講しているインストラクター）
    	shukeiDataDto = new ShukeiDataDto();
    	shukeiMaxDataList = new ArrayList<>();
    	shukeiMaxDataList = lesssonService.shukeiInstructorData(lessson);
    	shukeiDataDto.setShukeiName("MaxInstroctor");
    	shukeiDataDto.setShukeiValue(shukeiMaxDataList.get(0));
    	shukeiList.add(shukeiDataDto);
    	
    	//json
    	json = "";
    	
    	json = json + "{ \"shukei\" : "
    			+ "[";
	
		for(int i=0; i < shukeiList.size(); i++){
			json = json + "{\"shukeiName\":\"" + shukeiList.get(i).getShukeiName() +"\","
						+   "\"shukeiValue\":\"" + shukeiList.get(i).getShukeiValue() + "\""
						+ "}";
			if(i != shukeiList.size()-1){
				json = json + ",";
				
			}else{
				json = json +"] }";
							
			}
		}
		return "lesson.jsp";
    }
}
