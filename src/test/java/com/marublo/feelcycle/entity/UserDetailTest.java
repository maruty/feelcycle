package com.marublo.feelcycle.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

import static com.marublo.feelcycle.entity.UserDetailNames.*;

/**
 * {@link UserDetail}のテストクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2015/10/03 11:42:44")
public class UserDetailTest extends S2TestCase {

    private JdbcManager jdbcManager;

    /**
     * 事前処理をします。
     * 
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("s2jdbc.dicon");
    }

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    public void testFindById() throws Exception {
        jdbcManager.from(UserDetail.class).id(1).getSingleResult();
    }

    /**
     * userとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_user() throws Exception {
        jdbcManager.from(UserDetail.class).leftOuterJoin(user()).id(1).getSingleResult();
    }
}