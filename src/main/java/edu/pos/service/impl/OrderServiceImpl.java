package edu.pos.service.impl;

import edu.pos.dto.Order;
import edu.pos.entity.OrderEntity;
import edu.pos.entity.OrderItemEntity;
import edu.pos.repository.OrderDao;
import edu.pos.repository.OrderItemDao;
import edu.pos.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    final OrderDao orderDao;
    final OrderItemDao orderItemDao;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public OrderEntity placeOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerId(order.getCustomerId());
        orderEntity.setOrderDate(new Timestamp(System.currentTimeMillis()));
        orderEntity.setTotalAmount(order.getTotalPrice());

        OrderEntity savedOrder = orderDao.save(orderEntity);

        List<OrderItemEntity> orderItemEntities = order.getOrderItems().stream().map(item -> {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrder(savedOrder);
            orderItemEntity.setItemCode(item.getItemCode());
            orderItemEntity.setQuantity(item.getQuantity());
            orderItemEntity.setPrice(item.getPrice());
            orderItemEntity.setTotal(item.getQuantity() * item.getPrice());
            return orderItemEntity;
        }).collect(Collectors.toList());

        orderItemDao.saveAll(orderItemEntities);

        savedOrder.setOrderItems(orderItemEntities);

        return savedOrder;
    }
}