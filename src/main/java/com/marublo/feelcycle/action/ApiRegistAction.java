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
import javax.xml.xpath.XPathExpressionException;


import org.apache.http.ParseException;

import org.apache.http.client.config.RequestConfig;

import org.seasar.struts.annotation.Execute;

import com.marublo.feelcycle.dto.LessonDataDto;
import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.service.FeelcycleService;
import com.marublo.feelcycle.service.LesssonService;
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
	public FeelcycleService feelcycleService;

	@Resource
	public LesssonService lesssonService;
	
	/*************DI*******************/
	
	public List<User> userList;
	
	public String unko = "";
	public String loginId = "";
	public RequestConfig requestConfig;
	
    @Execute(validator = false, urlPattern = "{loginId}")
	public String index() {
    	
    	String unko = loginId;
    	
        return "index.jsp";
	}
    
    @Execute(validator = false)
    public String regist(){
    	
    	return "regist.jsp";
    }
    
}
