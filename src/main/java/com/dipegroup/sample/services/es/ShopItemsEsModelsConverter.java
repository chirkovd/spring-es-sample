package com.dipegroup.sample.services.es;

import com.dipegroup.sample.dao.ShopItemsDao;
import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.spring.es.services.app.converters.AbstractEsModelsConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    private ObjectMapper objectMapper;

    @Autowired
    public ShopItemsEsModelsConverter(ShopItemsDao appDao) {
        super(appDao);
    }

    @Override
    protected void merge(MongoShopItem stored, MongoShopItem item) {
        Optional.ofNullable(item.getName()).ifPresent(stored::setName);
        Optional.ofNullable(item.getDescription()).ifPresent(stored::setDescription);
        Optional.ofNullable(item.getComment()).ifPresent(stored::setComment);
        Optional.ofNullable(item.getPrice()).ifPresent(stored::setPrice);
        Optional.ofNullable(item.getDiscount()).ifPresent(stored::setDiscount);
        if (CollectionUtils.isNotEmpty(item.getColors())) {
            stored.setColors(item.getColors());
        }
        if (CollectionUtils.isNotEmpty(item.getSizes())) {
            stored.setSizes(item.getSizes());
        }
    }

    @Override
    public MongoShopItem targetToOriginal(EsShopItem target) {
        return objectMapper.convertValue(target, MongoShopItem.class);
    }

    @Override
    public EsShopItem originalToTarget(MongoShopItem original) {
        return objectMapper.convertValue(original, EsShopItem.class);
    }
}
