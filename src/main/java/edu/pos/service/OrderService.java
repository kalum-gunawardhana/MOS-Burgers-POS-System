package edu.pos.service;

import edu.pos.dto.Order;
import edu.pos.entity.OrderEntity;

public interface OrderService {
    OrderEntity placeOrder(Order order);
}