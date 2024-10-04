package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseCRUDRepository;
import com.platzi.market.persistence.entity.Purchase2;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private PurchaseCRUDRepository purchaseCRUDRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Purchase2>) purchaseCRUDRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCRUDRepository.findByIdConsumer(clientId)
                .map(purchase2s -> mapper.toPurchases(purchase2s));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Purchase2 purchase2 = mapper.toPurchase2(purchase);
        purchase2.getProducts().forEach(product -> product.setPurchase2(purchase2));

        return mapper.toPurchase(purchaseCRUDRepository.save(purchase2));
    }


}
