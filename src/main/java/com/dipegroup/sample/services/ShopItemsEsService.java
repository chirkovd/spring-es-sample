package com.dipegroup.sample.services;

import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.sample.repositories.EsShopItemsRepository;
import com.dipegroup.sample.services.es.ShopItemsEsModelsConverter;
import com.dipegroup.sample.services.es.ShopItemsEsPageInfoService;
import com.dipegroup.spring.es.services.es.ElasticsearchService;
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
public class ShopItemsEsService extends ElasticsearchService<MongoShopItem, EsShopItem, Long> {

    @Autowired
    public ShopItemsEsService(ShopItemsEsPageInfoService pageInfoService, EsShopItemsRepository repository,
                              ShopItemsEsModelsConverter converter) {
        super(pageInfoService, repository, converter);
    }
}
