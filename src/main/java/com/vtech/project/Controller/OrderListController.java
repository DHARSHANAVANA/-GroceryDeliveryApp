package com.vtech.project.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.project.Model.OrderList;

import com.vtech.project.Servicve.OrderListService;


@CrossOrigin("*")
@RestController
public class OrderListController {
	@Autowired
	OrderListService orderListService;

	@GetMapping("/getorderlist")
	public ArrayList<OrderList> getUser() {
		return orderListService.getAllOrderList();
	}
	@PostMapping("/postorderlist")
	public String saveUser(@RequestBody OrderList ol) {
		orderListService.saveOredrList(ol);
		return "data saved ";
	}

}
