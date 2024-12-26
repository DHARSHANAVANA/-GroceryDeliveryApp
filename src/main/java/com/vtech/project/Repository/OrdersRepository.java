package com.vtech.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vtech.project.Model.Orders;

@Repository
public interface OrdersRepository   extends CrudRepository<Orders, Long>{
	

}
