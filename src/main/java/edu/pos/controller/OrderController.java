package edu.pos.controller;

import edu.pos.dto.Order;
import edu.pos.entity.OrderEntity;
import edu.pos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderEntity> placeOrder(@RequestBody Order order) {
        OrderEntity savedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
}
