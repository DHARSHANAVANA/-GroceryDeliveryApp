package com.vtech.project.Servicve;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.Orders;
import com.vtech.project.Repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public ArrayList<Orders> getAllOrders() {
        return (ArrayList<Orders>) ordersRepository.findAll();
    }

    public void saveOrders(Orders order) {
        ordersRepository.save(order);
    }
}