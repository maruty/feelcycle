package com.marublo.feelcycle.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link UserFeelcycle}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/21 17:01:07")
public class UserFeelcycleNames {

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
     * userIdFeelcycleのプロパティ名を返します。
     * 
     * @return userIdFeelcycleのプロパティ名
     */
    public static PropertyName<String> userIdFeelcycle() {
        return new PropertyName<String>("userIdFeelcycle");
    }

    /**
     * userPassFeelcycleのプロパティ名を返します。
     * 
     * @return userPassFeelcycleのプロパティ名
     */
    public static PropertyName<String> userPassFeelcycle() {
        return new PropertyName<String>("userPassFeelcycle");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _UserFeelcycleNames extends PropertyName<UserFeelcycle> {

        /**
         * インスタンスを構築します。
         */
        public _UserFeelcycleNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserFeelcycleNames(final String name) {
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
        public _UserFeelcycleNames(final PropertyName<?> parent, final String name) {
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
         * userIdFeelcycleのプロパティ名を返します。
         *
         * @return userIdFeelcycleのプロパティ名
         */
        public PropertyName<String> userIdFeelcycle() {
            return new PropertyName<String>(this, "userIdFeelcycle");
        }

        /**
         * userPassFeelcycleのプロパティ名を返します。
         *
         * @return userPassFeelcycleのプロパティ名
         */
        public PropertyName<String> userPassFeelcycle() {
            return new PropertyName<String>(this, "userPassFeelcycle");
        }
    }
}