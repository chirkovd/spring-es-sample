package com.dipegroup.sample.repositories;

import com.dipegroup.exceptions.models.AppException;
import com.dipegroup.exceptions.services.messages.MessagesService;
import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.sample.services.ShopItemsFieldsService;
import com.dipegroup.sample.services.es.ShopItemsEsHighlightingService;
import com.dipegroup.spring.es.repositories.ElasticsearchExpandRepository;
import com.dipegroup.spring.es.services.es.ElasticsearchClientService;
import com.dipegroup.spring.es.services.es.ElasticsearchCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Repository
public class EsShopItemsRepository extends ElasticsearchExpandRepository<EsShopItem, Long> {

    @Autowired
    public EsShopItemsRepository(@Value("classpath:es/es.item.mapping.json") Resource mappingSource,
                                 @Value("classpath:es/es.settings.json") Resource settingsSource,
                                 ElasticsearchClientService clientService, MessagesService messagesService,
                                 ShopItemsFieldsService fieldsService, ElasticsearchCriteriaBuilder criteriaBuilder,
                                 ShopItemsEsHighlightingService highlightingService) throws AppException {

        super(clientService, messagesService, fieldsService, criteriaBuilder, EsShopItem.class, highlightingService);

        setIndex(EsShopItem.INDEX);
        setType(EsShopItem.TYPE);

        try {
            setMapping(mappingSource.getInputStream());
            setSetting(settingsSource.getInputStream());
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }

        if (!exists()) {
            create();
        }
    }
}
