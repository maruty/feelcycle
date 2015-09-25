package com.marublo.feelcycle.entity;

import com.marublo.feelcycle.entity.LesssonNames._LesssonNames;
import com.marublo.feelcycle.entity.UserFeelcycleNames._UserFeelcycleNames;
import com.marublo.feelcycle.entity.UserNames._UserNames;
import javax.annotation.Generated;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2015/09/25 10:54:21")
public class Names {

    /**
     * {@link Lessson}の名前クラスを返します。
     * 
     * @return Lesssonの名前クラス
     */
    public static _LesssonNames lessson() {
        return new _LesssonNames();
    }

    /**
     * {@link User}の名前クラスを返します。
     * 
     * @return Userの名前クラス
     */
    public static _UserNames user() {
        return new _UserNames();
    }

    /**
     * {@link UserFeelcycle}の名前クラスを返します。
     * 
     * @return UserFeelcycleの名前クラス
     */
    public static _UserFeelcycleNames userFeelcycle() {
        return new _UserFeelcycleNames();
    }
}