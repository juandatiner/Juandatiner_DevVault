package com.platzi.pizza.persistence.projection;

import java.time.LocalDateTime;

// Get the summary of the order
public interface OrderSummary {

    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
