package com.dipegroup.sample.services;

import com.dipegroup.exceptions.models.AppException;
import com.dipegroup.sample.models.EsShopItem;
import com.dipegroup.spring.es.models.fields.FilterWorkflowField;
import com.dipegroup.spring.es.models.fields.SearchWorkflowField;
import com.dipegroup.spring.es.models.fields.SortWorkflowField;
import com.dipegroup.spring.es.models.fields.WorkflowFieldsContainer;
import com.dipegroup.spring.es.services.app.page.AppFieldsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Service
public class ShopItemsFieldsService implements AppFieldsService<EsShopItem> {

    private WorkflowFieldsContainer container;

    @Autowired
    public void init(ObjectMapper objectMapper, @Value("classpath:app/app.shop.item.json") Resource source)
            throws AppException {

        try {
            container = objectMapper.readValue(source.getInputStream(), WorkflowFieldsContainer.class);
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }
    }

    @Override
    public List<FilterWorkflowField> getFilters() {
        return container.getFilters();
    }

    @Override
    public List<SortWorkflowField> getSorting() {
        return container.getSorting();
    }

    @Override
    public List<SearchWorkflowField> getSearches() {
        return container.getSearches();
    }
}
