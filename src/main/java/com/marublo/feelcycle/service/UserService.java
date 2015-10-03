package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.User;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;




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
	
		return jdbcManager.from(User.class).innerJoin("userFeelCycleList").innerJoin("userDetail").getResultList();
	}
	
	public boolean registUser(User user){
		
		int count = jdbcManager.insert(user).execute();
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