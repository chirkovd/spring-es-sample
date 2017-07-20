package com.dipegroup.sample.services.es;

import com.dipegroup.sample.dao.ShopItemsDao;
import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.spring.es.services.app.converters.AbstractEsModelsConverter;
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
public class ShopItemsEsModelsConverter extends AbstractEsModelsConverter<MongoShopItem, EsShopItem, Long> {

    @Autowired
    public ShopItemsEsModelsConverter(ShopItemsDao appDao) {
        super(appDao);
    }

    @Override
    protected void merge(MongoShopItem stored, MongoShopItem item) {
        // TODO: 7/20/2017 implement method
    }

    @Override
    public MongoShopItem targetToOriginal(EsShopItem target) {
        // TODO: 7/20/2017 implement method
        return null;
    }

    @Override
    public EsShopItem originalToTarget(MongoShopItem original) {
        // TODO: 7/20/2017 implement method
        return null;
    }
}
