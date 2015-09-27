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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.seasar.struts.annotation.Execute;

import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.service.FeelcycleService;
import com.marublo.feelcycle.service.UserService;





public class IndexAction {
	
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
	public FeelcycleService feelcycleService;
	
	/*************DI*******************/
	
	public List<User> userList;
	
	public String unko = "";
	public RequestConfig requestConfig;
	
    @Execute(validator = false)
	public String index() {
    	//ユーザー情報の取得
    	userList = userService.getAllUser();
    	//これあとでDTOに変える
    	String getLessonDataDto = "";
    	
    	
    	for(int i=0; i < userList.size(); i++){
    		for(int j=0; j < userList.get(i).userFeelCycleList.size(); j++){
    			try {
					getLessonDataDto = feelcycleService.getPage(userList.get(i).userFeelCycleList.get(j).userIdFeelcycle
												, userList.get(i).userFeelCycleList.get(j).userPassFeelcycle);
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
    			System.out.println(userList.get(i).userFeelCycleList.get(j).userIdFeelcycle);
    			//System.out.println(userList.get(i).userFeelCycleList.get(j).userPassFeelcycle);
    		}
    		//userオブジェクトを元にログイン

    		
    		
    		//getHtml = feelcycleService.getPage("mypage",user);
    		
    		
    		
    		
    	}
    	
    	
    	
    	
    	//ユーザー情報を元に各受講データを取得
    	
    	
    	//新規に追加したレッスンのみをインサートする
    	
    	
    	//終了処理
    	
  
    	
    	//UserService userService = new UserService();
    	
    	
    	
		//List<User> teuserList = jdbcManager.from(User.class)
        //        .getResultList();
    	
		//System.out.println("aa");
		
		
    	//List<User> userList = userService.getAllUser();
    	//this.unko = userList.get(0).userId.toString();
    	
        return "index.jsp";
	}
}
