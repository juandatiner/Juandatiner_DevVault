package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Purchase2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCRUDRepository extends CrudRepository<Purchase2, Integer> {

    Optional<List<Purchase2>> findByIdConsumer(String idConsumer);
}
