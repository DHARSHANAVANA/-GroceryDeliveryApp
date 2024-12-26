package com.vtech.project.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.project.Model.Orders;
import com.vtech.project.Servicve.OrdersService;

@CrossOrigin("*")
@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    public ArrayList<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/orders")
    public ResponseEntity<String> saveOrders(@RequestBody Orders order) {
        try {
            ordersService.saveOrders(order);
            return new ResponseEntity<>("Order saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
