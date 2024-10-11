package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCRUDrepository extends CrudRepository<Product2, Integer> { //<class, typePK>

//    @Query(value = "SELECT * FROM productos WHERE idCategory = ?", nativeQuery = true)
    List<Product2> findByIdCategoryOrderByNameAsc(int idCategory); //Query Method

    Optional<List<Product2>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
