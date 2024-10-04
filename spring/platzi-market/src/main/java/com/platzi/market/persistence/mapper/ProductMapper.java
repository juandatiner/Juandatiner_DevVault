package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Product2;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) // uses help us when use category because category has her mapper
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct",target = "productId"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "idCategory",target = "categoryId"),
            @Mapping(source = "priceSale",target = "price"),
            @Mapping(source = "stockQuantity",target = "stock"),
            @Mapping(source = "state",target = "active"),
            @Mapping(source = "category",target = "category"),
    })
    Product toProduct(Product2 product2); // convert Product2 (persistence/entity) to Product (domain/service)
    List<Product> toProducts(List<Product2> product2s);

    @InheritInverseConfiguration // inverse the previous mapper
    @Mapping(target = "barCode", ignore = true) // as in Product2 exist and attribute {barcode} but we don't need
    Product2 toProduct2(Product product); // convert Product (domain/service) to Product2 (persistence/entity)
}
