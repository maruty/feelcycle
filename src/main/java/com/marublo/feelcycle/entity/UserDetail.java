package com.marublo.feelcycle.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * UserDetailエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/10/03 11:03:50")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer id;

    /** userIdプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userId;

    /** nickNameプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String nickName;
    
    /** User と1対1での結合 **/
    
    @OneToOne
    @JoinColumn(name="USER_ID", referencedColumnName="USER_ID") 
    public User user;
    
}