package com.marublo.feelcycle.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * UserFeelcycleエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/09/21 17:01:04")
public class UserFeelcycle implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer id;

    /** userIdプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userId;

    /** userIdFeelcycleプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userIdFeelcycle;

    /** userPassFeelcycleプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userPassFeelcycle;
}