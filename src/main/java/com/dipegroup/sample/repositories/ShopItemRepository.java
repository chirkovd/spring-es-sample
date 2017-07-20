package com.dipegroup.sample.repositories;

import com.dipegroup.sample.models.MongoShopItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Repository
public interface ShopItemRepository extends CrudRepository<MongoShopItem, Long> {

    MongoShopItem findByName(String name);

}
