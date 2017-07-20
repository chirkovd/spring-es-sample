package com.dipegroup.sample.services.es;

import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.spring.es.models.es.EsHighlightedField;
import com.dipegroup.spring.es.services.es.ElasticsearchHighlightingService;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

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
        List<EsHighlightedField<EsShopItem, Long>> fieldsList = Arrays.asList(HighlightedFields.values());

        fieldsList.add(new EsHighlightedField<EsShopItem, Long>() {
            @Override
            public String getName() {
                return "colors";
            }
            @Override
            public BiConsumer<EsShopItem, String> getConsumer() {
                return (item, content) -> item.setColors(highlightArray(item.getColors(), content));
            }
        });

        fieldsList.add(new EsHighlightedField<EsShopItem, Long>() {
            @Override
            public String getName() {
                return "sizes";
            }
            @Override
            public BiConsumer<EsShopItem, String> getConsumer() {
                return (item, content) -> item.setSizes(highlightArray(item.getSizes(), content));
            }
        });

        return fieldsList;
    }

    private enum HighlightedFields implements EsHighlightedField<EsShopItem, Long> {

        NAME("name", EsShopItem::setName),
        DESCRIPTION("description", EsShopItem::setDescription),
        COMMENT("comment", EsShopItem::setComment),
        TYPE("type", EsShopItem::setType);

        private String name;
        private BiConsumer<EsShopItem, String> consumer;

        HighlightedFields(String name, BiConsumer<EsShopItem, String> consumer) {
            this.name = name;
            this.consumer = consumer;
        }

        public String getName() {
            return name;
        }

        public BiConsumer<EsShopItem, String> getConsumer() {
            return consumer;
        }
    }
}
