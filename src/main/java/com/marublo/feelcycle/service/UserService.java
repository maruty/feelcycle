package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.User;


import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;




import static com.marublo.feelcycle.entity.UserNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link User}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class UserService{
	
	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	/*************DI*******************/
	
	
	//全ユーザー（紐づくFCのログイン情報も含め）取得
	public List<User> getAllUser(){
		
	
	
		return jdbcManager.from(User.class).innerJoin("userFeelCycleList").getResultList();
	}



}