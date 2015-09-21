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


public class IndexAction {
	@Resource
	public JdbcManager jdbcManager;
	
	
	public String unko = "";
	
    @Execute(validator = false)
	public String index() {
    	//String unko = "うんこー";
    	//UserService user = new UserService();
    	
    	List<User> userList = jdbcManager.from(User.class)
                .getResultList();
    	
    	
    	this.unko = userList.get(0).userId.toString();
    	
        return "index.jsp";
	}
}
