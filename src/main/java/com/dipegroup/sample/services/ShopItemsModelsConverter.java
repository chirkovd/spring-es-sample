package com.dipegroup.sample.services;

import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.sample.models.ShopItem;
import com.dipegroup.spring.es.services.app.converters.AbstractModelsConverter;
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
public class ShopItemsModelsConverter extends AbstractModelsConverter<ShopItem, MongoShopItem> {

    @Override
    public ShopItem targetToOriginal(MongoShopItem target) {
        // TODO: 7/20/2017 implement method
        return null;
    }

    @Override
    public MongoShopItem originalToTarget(ShopItem original) {
        // TODO: 7/20/2017 implement method
        return null;
    }
}
