package com.dipegroup.sample.services.es;

import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.repositories.EsShopItemsRepository;
import com.dipegroup.sample.services.ShopItemsFieldsService;
import com.dipegroup.spring.es.services.app.page.AbstractPageInfoService;
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
public class ShopItemsEsPageInfoService extends AbstractPageInfoService<EsShopItem> {

    @Autowired
    protected ShopItemsEsPageInfoService(EsShopItemsRepository repository, ShopItemsFieldsService fieldsService) {
        super(repository, fieldsService);
    }
}
