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

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.struts.annotation.Execute;

import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.entity.UserFeelcycle;
import com.marublo.feelcycle.service.UserService;
import static org.seasar.extension.jdbc.operation.Operations.*;


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
	/*************DI*******************/
	
	public String unko = "";
	
    @Execute(validator = false)
	public String index() {
    	//ユーザー情報の取得
    	
    	
    	
    	
    	//ユーザー情報を元に各受講データを取得
    	
    	
    	//新規に追加したレッスンのみをインサートする
    	
    	
    	//終了処理
    	
  
    	
    	//UserService userService = new UserService();
    	List<User> a = userService.getAllUser();
    	
    	
		//List<User> teuserList = jdbcManager.from(User.class)
        //        .getResultList();
    	
		//System.out.println("aa");
		
		
    	//List<User> userList = userService.getAllUser();
    	//this.unko = userList.get(0).userId.toString();
    	
        return "index.jsp";
	}
}
