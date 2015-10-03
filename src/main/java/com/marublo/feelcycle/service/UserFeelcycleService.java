package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.UserFeelcycle;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;

import static com.marublo.feelcycle.entity.UserFeelcycleNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link UserFeelcycle}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class UserFeelcycleService extends AbstractService<UserFeelcycle> {

	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	/*************DI*******************/
	
	
	
    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public UserFeelcycle findById(Integer id) {
        return select().id(id).getSingleResult();
    }
    
    public boolean registUser(UserFeelcycle userFeelcycle){
    	int count = jdbcManager.insert(userFeelcycle).execute();
		//1だったら更新成功
		
		if(count == 1){
			return true;
		}else{
			return false;
		}
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<UserFeelcycle> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}