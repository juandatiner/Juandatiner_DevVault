package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Category2;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active"),
    })
    Category toCategory(Category2 category2); // convert Category2 (persistence/entity) to Category (domain/service)

    @InheritInverseConfiguration // inverse the previous mapper
    @Mapping(target = "products", ignore = true) // as in Category2 exist and attribute {products} but we don't need
    Category2 toCategory2(Category category); // convert Category (domain/service) to Category2 (persistence/entity)
}
