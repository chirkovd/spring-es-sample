package com.dipegroup.sample.dao;

import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.spring.es.dao.AppDao;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
public interface ShopItemsDao extends AppDao<MongoShopItem, Long> {
}
