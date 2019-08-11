package com.bijays.errorhandling.service;

import com.bijays.errorhandling.exception.OrderServiceException;
import com.bijays.errorhandling.modal.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    // return order list
    public List<Order> getOrders() {
        List<Order> shops = new ArrayList<>();

        Order shopOne = new Order();
        shopOne.setName("Order One Monitor Manager");
        shopOne.setQuantity(2);
        shopOne.setPrice(70000000.00);
        shopOne.setId(UUID.randomUUID().toString().replace("-", ""));

        Order shopTwo = new Order();
        shopTwo.setName("Order Two Monitor Manager");
        shopTwo.setQuantity(10);
        shopTwo.setPrice(50000000.00);
        shopTwo.setId(UUID.randomUUID().toString().replace("-", ""));

        shops.add(shopOne);
        shops.add(shopTwo);
        return shops;
    }

    // return order as null
    public Order getOrderNull() {
        return null;
    }

    // throw exception
    public Order getOrderException() throws OrderServiceException {
        throw new OrderServiceException();
    }

}
