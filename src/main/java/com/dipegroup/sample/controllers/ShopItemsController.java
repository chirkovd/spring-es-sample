package com.dipegroup.sample.controllers;

import com.dipegroup.exceptions.models.AppException;
import com.dipegroup.sample.models.ShopItem;
import com.dipegroup.sample.services.ShopItemsService;
import com.dipegroup.spring.es.models.beans.FiltersBean;
import com.dipegroup.spring.es.models.beans.ResultsBean;
import com.dipegroup.spring.es.models.filters.FilterGroup;
import com.dipegroup.spring.es.models.results.Results;
import com.dipegroup.spring.es.models.results.ResultsPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@RestController
public class ShopItemsController {

    @Autowired
    private ShopItemsService shopItemsService;

    @RequestMapping(value = "/items/info", method = RequestMethod.GET)
    public ResultsPageInfo getInfo() {
        return shopItemsService.getInfo();
    }

    @RequestMapping(value = "/items/results", method = RequestMethod.POST)
    public Results<ShopItem> loadResults(@Valid @RequestBody ResultsBean resultsBean) throws AppException {
        return shopItemsService.loadResults(resultsBean);
    }

    @RequestMapping(value = "/items/filters", method = RequestMethod.POST)
    public Map<String, FilterGroup> loadFilters(@Valid @RequestBody FiltersBean filtersBean) throws AppException {
        return shopItemsService.loadFilters(filtersBean);
    }

    @RequestMapping(value = "/items/expand", method = RequestMethod.GET)
    public List<ShopItem> searchByTerm(@RequestParam String term) throws AppException {
        return shopItemsService.searchByTerm(term);
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ShopItem addToSearch(@Valid @RequestBody ShopItem item) throws AppException {
        return shopItemsService.addToSearch(item);
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public void updateInSearch(@Valid @RequestBody ShopItem item) throws AppException {
        shopItemsService.updateInSearch(item);
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public void deleteFromSearch(@PathVariable long id) throws AppException {
        shopItemsService.deleteFromSearch(id);
    }

}
