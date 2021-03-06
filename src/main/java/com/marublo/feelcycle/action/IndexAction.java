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

	@Resource
	public LesssonService lesssonService;
	
	/*************DI*******************/
	/*************Param*******************/
	public List<User> userList;
	public String unko = "";
	public RequestConfig requestConfig;
	/*************Param*******************/
	
	
    @Execute(validator = false)
	public String index() {
    	//ユーザー情報の取得
    	userList = userService.getAllUser();
    	List<LessonDataDto> getLessonDataDtoList = new ArrayList<LessonDataDto>();
    	
    	for(int i=0; i < userList.size(); i++){
    		for(int j=0; j < userList.get(i).userFeelCycleList.size(); j++){
    			try {
					try {
						//1ID単位のレッスン履歴情報がくる
						getLessonDataDtoList = feelcycleService.getPage(userList.get(i).userFeelCycleList.get(j).userIdFeelcycle
													, userList.get(i).userFeelCycleList.get(j).userPassFeelcycle
													,userList.get(i).userId);
						
						//セレクトして存在してなかったらインサートする
						for(LessonDataDto lesson : getLessonDataDtoList){
							if(lesssonService.checkLessonData(lesson)){
								//trueだったら存在していないのでインサートする
								lesssonService.insertLessonData(lesson);
							}else{
								//falseだったら存在してないのでインサートしない
							}
						}
						
					} catch (XPathExpressionException | ParseException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
    			//System.out.println(userList.get(i).userFeelCycleList.get(j).userIdFeelcycle);
    			//System.out.println(userList.get(i).userFeelCycleList.get(j).userPassFeelcycle);
    		}
    		getLessonDataDtoList = new ArrayList<LessonDataDto>();
    	}
        return "index.jsp";
	}
}
