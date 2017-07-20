package com.dipegroup.sample.services.es;

import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.spring.es.models.es.EsHighlightedField;
import com.dipegroup.spring.es.services.es.ElasticsearchHighlightingService;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Service
public class ShopItemsEsHighlightingService extends ElasticsearchHighlightingService<EsShopItem, Long> {

    @Autowired
    protected ShopItemsEsHighlightingService(HighlightBuilder highlightBuilder) {
        super(highlightBuilder);
    }

    @Override
    protected Collection<EsHighlightedField<EsShopItem, Long>> getFields() {
        // TODO: 7/20/2017 implement method
        return null;
    }


}
