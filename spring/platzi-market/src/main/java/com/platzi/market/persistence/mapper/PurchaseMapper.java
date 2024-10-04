package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.Purchase2;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idConsumer", target = "clientId"),
            @Mapping(source = "dateTime", target = "date"),
            @Mapping(source = "commentary", target = "comment"),
            @Mapping(source = "products", target = "items")

    })
    Purchase toPurchase(Purchase2 purchase2);
    List<Purchase> toPurchases(List<Purchase2> purchase2s);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "consumer", ignore = true)
    })
    Purchase2 toPurchase2(Purchase purchase);

}
