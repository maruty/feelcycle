package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.User;
import com.marublo.feelcycle.entity.UserDetail;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;




/**
 * {@link User}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class UserDetailService{
	
	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	/*************DI*******************/
	
	
	public boolean registUser(UserDetail userDetail){
		
		int count = jdbcManager.insert(userDetail).execute();
		//1だったら更新成功
		
		if(count == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//ユーザー登録やDBに値を聞く際にパスワードのハッシュ化を行う
	/*
	 * salt＋ハッシュ化したパスワードを取得
	 */
	public String getSaltedPassword(String password, String userId) {
		String salt = getSha256(userId);
	    return getSha256(salt + password);
	}

	  /*
	   * 文字列から SHA256 のハッシュ値を取得
	   */
	private String getSha256(String target) {
	  MessageDigest md = null;
	  StringBuffer buf = new StringBuffer();
	  try {
	    md = MessageDigest.getInstance("SHA-256");
	    md.update(target.getBytes());
	    byte[] digest = md.digest();
	 
	    for (int i = 0; i < digest.length; i++) {
	      buf.append(String.format("%02x", digest[i]));
	    }
	  } catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	  }
	 
	    return buf.toString();
	}
}