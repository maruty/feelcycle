package com.marublo.feelcycle.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Lessson}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/10/03 11:42:39")
public class LesssonNames {

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
     * lessonNameのプロパティ名を返します。
     * 
     * @return lessonNameのプロパティ名
     */
    public static PropertyName<String> lessonName() {
        return new PropertyName<String>("lessonName");
    }

    /**
     * instructorのプロパティ名を返します。
     * 
     * @return instructorのプロパティ名
     */
    public static PropertyName<String> instructor() {
        return new PropertyName<String>("instructor");
    }

    /**
     * lessonDateのプロパティ名を返します。
     * 
     * @return lessonDateのプロパティ名
     */
    public static PropertyName<String> lessonDate() {
        return new PropertyName<String>("lessonDate");
    }

    /**
     * lessonTimeFromのプロパティ名を返します。
     * 
     * @return lessonTimeFromのプロパティ名
     */
    public static PropertyName<String> lessonTimeFrom() {
        return new PropertyName<String>("lessonTimeFrom");
    }

    /**
     * lessonTimeToのプロパティ名を返します。
     * 
     * @return lessonTimeToのプロパティ名
     */
    public static PropertyName<String> lessonTimeTo() {
        return new PropertyName<String>("lessonTimeTo");
    }

    /**
     * lessonTenpoのプロパティ名を返します。
     * 
     * @return lessonTenpoのプロパティ名
     */
    public static PropertyName<String> lessonTenpo() {
        return new PropertyName<String>("lessonTenpo");
    }

    /**
     * lessonMashineのプロパティ名を返します。
     * 
     * @return lessonMashineのプロパティ名
     */
    public static PropertyName<String> lessonMashine() {
        return new PropertyName<String>("lessonMashine");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _LesssonNames extends PropertyName<Lessson> {

        /**
         * インスタンスを構築します。
         */
        public _LesssonNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _LesssonNames(final String name) {
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
        public _LesssonNames(final PropertyName<?> parent, final String name) {
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
         * lessonNameのプロパティ名を返します。
         *
         * @return lessonNameのプロパティ名
         */
        public PropertyName<String> lessonName() {
            return new PropertyName<String>(this, "lessonName");
        }

        /**
         * instructorのプロパティ名を返します。
         *
         * @return instructorのプロパティ名
         */
        public PropertyName<String> instructor() {
            return new PropertyName<String>(this, "instructor");
        }

        /**
         * lessonDateのプロパティ名を返します。
         *
         * @return lessonDateのプロパティ名
         */
        public PropertyName<String> lessonDate() {
            return new PropertyName<String>(this, "lessonDate");
        }

        /**
         * lessonTimeFromのプロパティ名を返します。
         *
         * @return lessonTimeFromのプロパティ名
         */
        public PropertyName<String> lessonTimeFrom() {
            return new PropertyName<String>(this, "lessonTimeFrom");
        }

        /**
         * lessonTimeToのプロパティ名を返します。
         *
         * @return lessonTimeToのプロパティ名
         */
        public PropertyName<String> lessonTimeTo() {
            return new PropertyName<String>(this, "lessonTimeTo");
        }

        /**
         * lessonTenpoのプロパティ名を返します。
         *
         * @return lessonTenpoのプロパティ名
         */
        public PropertyName<String> lessonTenpo() {
            return new PropertyName<String>(this, "lessonTenpo");
        }

        /**
         * lessonMashineのプロパティ名を返します。
         *
         * @return lessonMashineのプロパティ名
         */
        public PropertyName<String> lessonMashine() {
            return new PropertyName<String>(this, "lessonMashine");
        }
    }
}