package com.marublo.feelcycle.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Userエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/09/21 17:01:04")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer id;

    /** userIdプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userId;

    /** userPassプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userPass;
    
    /** UserFeelCycleテーブルとjoin用のパラメータ※テーブル間の結合を定義
     * 1のエンティティに多のエンティティを定義 **/
    //<--TableTwoが多対１の１であること、自身がTableOneで
    //   tableTwoとして定義されていることを追加
    @OneToMany(mappedBy="user")
    public List<UserFeelcycle> userFeelCycleList; 
    
}