package com.bijays.errorhandling.controller;

import com.bijays.errorhandling.exception.ContentNotFoundException;
import com.bijays.errorhandling.exception.OrderServiceException;
import com.bijays.errorhandling.exception.ResourceNotFoundException;
import com.bijays.errorhandling.modal.Order;
import com.bijays.errorhandling.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private static final String ORDERS_NOT_FOUND = "Orders not found";
    private static final String ORDERS_RESOURCE_NOT_FOUND = "Resource Not Found.";
    private static final String INTERNAL_SERVER_ERROR = "Internal Server Exception while getting orders.";

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders")
    public List<Order> getAllOrders() throws ContentNotFoundException {
        List<Order> orders = orderService.getOrders();
        if (orders == null) {
            throw new ContentNotFoundException(Order.class, "none");
        }
        return orders;
    }

    @GetMapping(value = "/order/{id}")
    public Order getUnknownOrder(@PathVariable("id") Long id) throws ContentNotFoundException{
        Order order = orderService.getOrderNull();
        if (order == null) {
            throw new ContentNotFoundException(Order.class, "id", id.toString());
        }

        return order;
    }

    @GetMapping(value = "/order-two")
    public Order getUnknownOrderTwo() throws OrderServiceException, ContentNotFoundException{
        try {
            Order order = orderService.getOrderException();
            if (order == null) {
                throw new ContentNotFoundException(Order.class, "none");
            }
            throw new OrderServiceException(INTERNAL_SERVER_ERROR);
        } catch (OrderServiceException e) {
            throw new OrderServiceException(INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/not-found")
    public void getResource(){
        throw new ResourceNotFoundException(ORDERS_RESOURCE_NOT_FOUND);
    }
}
