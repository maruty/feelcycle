package com.marublo.feelcycle.entity;

import com.marublo.feelcycle.entity.UserNames._UserNames;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link UserDetail}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/10/03 11:42:39")
public class UserDetailNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<String> userId() {
        return new PropertyName<String>("userId");
    }

    /**
     * nickNameのプロパティ名を返します。
     * 
     * @return nickNameのプロパティ名
     */
    public static PropertyName<String> nickName() {
        return new PropertyName<String>("nickName");
    }

    /**
     * userのプロパティ名を返します。
     * 
     * @return userのプロパティ名
     */
    public static _UserNames user() {
        return new _UserNames("user");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _UserDetailNames extends PropertyName<UserDetail> {

        /**
         * インスタンスを構築します。
         */
        public _UserDetailNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserDetailNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _UserDetailNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * idのプロパティ名を返します。
         *
         * @return idのプロパティ名
         */
        public PropertyName<Integer> id() {
            return new PropertyName<Integer>(this, "id");
        }

        /**
         * userIdのプロパティ名を返します。
         *
         * @return userIdのプロパティ名
         */
        public PropertyName<String> userId() {
            return new PropertyName<String>(this, "userId");
        }

        /**
         * nickNameのプロパティ名を返します。
         *
         * @return nickNameのプロパティ名
         */
        public PropertyName<String> nickName() {
            return new PropertyName<String>(this, "nickName");
        }

        /**
         * userのプロパティ名を返します。
         * 
         * @return userのプロパティ名
         */
        public _UserNames user() {
            return new _UserNames(this, "user");
        }
    }
}