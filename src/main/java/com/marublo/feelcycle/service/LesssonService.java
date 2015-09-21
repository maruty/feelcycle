package com.marublo.feelcycle.service;

import com.marublo.feelcycle.entity.Lessson;
import java.util.List;
import javax.annotation.Generated;

import static com.marublo.feelcycle.entity.LesssonNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Lessson}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class LesssonService extends AbstractService<Lessson> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Lessson findById(Integer id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Lessson> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}