package com.marublo.feelcycle.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Lesssonエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/09/21 17:01:04")
public class Lessson implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer id;

    /** userIdプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String userId;

    /** lessonNameプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonName;

    /** instructorプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String instructor;

    /** lessonDateプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonDate;

    /** lessonTimeFromプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonTimeFrom;

    /** lessonTimeToプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonTimeTo;

    /** lessonTenpoプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonTenpo;
    
    /** lessonMashineプロパティ */
    @Column(length = 64, nullable = true, unique = false)
    public String lessonMashine;
    
    
    public String getlessonDate(){
    	return lessonDate;
    }
}