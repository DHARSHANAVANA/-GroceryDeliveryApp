package com.vtech.project.Servicve;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.OrderList;
import com.vtech.project.Repository.OrderListRepository;


@Service
public class OrderListService {
	@Autowired
	 OrderListRepository  orderListRepository;
		public ArrayList<OrderList> getAllOrderList() {
			return (ArrayList<OrderList>) orderListRepository.findAll();
		}
		public void saveOredrList(OrderList ol) {
			orderListRepository.save(ol);
		}

}
