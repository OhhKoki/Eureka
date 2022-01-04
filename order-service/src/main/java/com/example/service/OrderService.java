package com.example.service;

import com.example.entity.Order;

public interface OrderService {

    Order queryOrderById(Long orderId);

}
