package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductCRUDrepository;
import com.platzi.market.persistence.entity.Product2;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired // the objects that received, spring instance, should be from spring
    private ProductCRUDrepository productCRUDrepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Product2> product2s = (List<Product2>) productCRUDrepository.findAll();
        return mapper.toProducts(product2s);
    }

    public Optional<List<Product>> getByCategory(int CategoryId) {
        List<Product2> product2s = productCRUDrepository.findByIdCategoryOrderByNameAsc(CategoryId);
        return Optional.of(mapper.toProducts(product2s)); // return an optional
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Product2>> product2s = productCRUDrepository.findByStockQuantityLessThanAndState(quantity, true );
        return product2s.map(prods -> mapper.toProducts(prods)); // return an optional
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCRUDrepository.findById(productId).map(product2 -> mapper.toProduct(product2));
    }

    @Override
    public Product save(Product product) {
        Product2 product2 = mapper.toProduct2(product);
        return mapper.toProduct(productCRUDrepository.save(product2));
    }

    @Override
    public void delete(int productId) {
        productCRUDrepository.deleteById(productId);
    }


}
