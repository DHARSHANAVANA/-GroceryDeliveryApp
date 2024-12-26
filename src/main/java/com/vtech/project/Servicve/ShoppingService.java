package com.vtech.project.Servicve;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.Shopping;

import com.vtech.project.Repository.ShoppingRepository;

@Service
public class ShoppingService {
	@Autowired
ShoppingRepository shoppingRepository;
public ArrayList<Shopping> getAllShoppings() {
	return (ArrayList<Shopping>) shoppingRepository.findAll();
}
public void saveShopping(Shopping s) {
	shoppingRepository.save(s);
}

}
