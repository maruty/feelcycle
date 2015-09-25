package com.marublo.feelcycle.entity;

import com.marublo.feelcycle.entity.UserFeelcycleNames._UserFeelcycleNames;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link User}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/25 10:54:21")
public class UserNames {

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
     * userPassのプロパティ名を返します。
     * 
     * @return userPassのプロパティ名
     */
    public static PropertyName<String> userPass() {
        return new PropertyName<String>("userPass");
    }

    /**
     * userFeelCycleListのプロパティ名を返します。
     * 
     * @return userFeelCycleListのプロパティ名
     */
    public static _UserFeelcycleNames userFeelCycleList() {
        return new _UserFeelcycleNames("userFeelCycleList");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _UserNames extends PropertyName<User> {

        /**
         * インスタンスを構築します。
         */
        public _UserNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserNames(final String name) {
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
        public _UserNames(final PropertyName<?> parent, final String name) {
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
         * userPassのプロパティ名を返します。
         *
         * @return userPassのプロパティ名
         */
        public PropertyName<String> userPass() {
            return new PropertyName<String>(this, "userPass");
        }

        /**
         * userFeelCycleListのプロパティ名を返します。
         * 
         * @return userFeelCycleListのプロパティ名
         */
        public _UserFeelcycleNames userFeelCycleList() {
            return new _UserFeelcycleNames(this, "userFeelCycleList");
        }
    }
}