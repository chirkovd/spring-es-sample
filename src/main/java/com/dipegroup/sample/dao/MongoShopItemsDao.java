package com.dipegroup.sample.dao;

import com.dipegroup.exceptions.models.AppException;
import com.dipegroup.sample.models.MongoShopItem;
import com.dipegroup.sample.repositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Component
public class MongoShopItemsDao implements ShopItemsDao {

    @Autowired
    private ShopItemRepository repository;

    @Override
    public MongoShopItem create(MongoShopItem item) throws AppException {
        return repository.save(item);
    }

    @Override
    public MongoShopItem update(MongoShopItem item) {
        return repository.save(item);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }

    @Override
    public MongoShopItem get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<MongoShopItem> get(Collection<Long> ids) {
        return (List<MongoShopItem>) repository.findAll(ids);
    }

    @Override
    public MongoShopItem findByKey(String key) {
        return repository.findByName(key);
    }

    @Override
    public boolean exist(Long id) {
        return repository.exists(id);
    }

    @Override
    public void clean() {
        repository.deleteAll();
    }
}
