package com.dipegroup.sample.services;

import com.dipegroup.sample.dao.ShopItemsDao;
import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.sample.models.ShopItem;
import com.dipegroup.spring.es.services.app.AbstractAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Service
public class ShopItemsService extends AbstractAppService<ShopItem, MongoShopItem, EsShopItem, Long> {

    @Autowired
    public ShopItemsService(ShopItemsDao appDao, ShopItemsModelsConverter converter,
                            ShopItemsEsService elasticsearchService) {
        super(appDao, converter, elasticsearchService);
    }
}
