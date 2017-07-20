package com.dipegroup.sample.services;

import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.sample.models.ShopItem;
import com.dipegroup.spring.es.services.app.converters.AbstractModelsConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ShopItemsModelsConverter extends AbstractModelsConverter<ShopItem, MongoShopItem> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ShopItem targetToOriginal(MongoShopItem target) {
        return objectMapper.convertValue(target, ShopItem.class);
    }

    @Override
    public MongoShopItem originalToTarget(ShopItem original) {
        return objectMapper.convertValue(original, MongoShopItem.class);
    }
}
