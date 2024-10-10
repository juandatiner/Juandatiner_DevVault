package com.platzi.pizza.persistence.projection;
// projection: It allows returning a single field without needing to return the entire entity.
import java.time.LocalDateTime;

// Get the summary of the order
public interface OrderSummary {

    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
