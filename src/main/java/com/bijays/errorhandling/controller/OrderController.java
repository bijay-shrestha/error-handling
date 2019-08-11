package com.bijays.errorhandling.controller;

import com.bijays.errorhandling.exception.*;
import com.bijays.errorhandling.modal.Order;
import com.bijays.errorhandling.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders")
    public List<Order> getAllOrders(){
        List<Order> orders = orderService.getOrders();
        if (orders == null) {
            throw new DataNotFoundException(Order.class, "Orders returned empty.");
        }
        return orders;
    }

    @GetMapping(value = "/order/{orderId}")
    public Order getUnknownOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrderNull();
        if (order == null) {
            throw new DataNotFoundException(Order.class, "orderId",orderId.toString());
        }

        return order;
    }

    @GetMapping("/order-not-found")
    public void getNullPointerException(){
        throw new DataNotFoundException(Order.class, "Object returned null.");
    }

    @GetMapping("/order-invalid")
    public void getExpectationFailedException(){
        throw new OperationUnSuccessfulException(Order.class, "Error! Error! Error!");
    }
}
