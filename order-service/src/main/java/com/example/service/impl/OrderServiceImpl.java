package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order queryById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 调用 user-service 服务查询用户信息
//        String url = "http://localhost:8081/user/" + order.getUserId();
        String url = "http://user-service/user/" + order.getUserId();
        UserDTO userDTO = restTemplate.getForObject(url, UserDTO.class);
        // 3. 将 user 设置到 order 中
        order.setUserDTO(userDTO);
        // 4. 返回
        return order;
    }

}
