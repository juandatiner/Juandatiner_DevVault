package com.platzi.pizza.service.dto;

import lombok.Data;

//Data transfer object
@Data
public class UpdatePizzaPriceDto {

    private int pizzaId;
    private double newPrice;
}
