package com.vtech.project.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.vtech.project.Model.Shopping;
import com.vtech.project.Servicve.ShoppingService;

@CrossOrigin("*")
@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;
	
	@GetMapping("/getshopping")
	public ArrayList<Shopping> getShopping() {
		return shoppingService.getAllShoppings();
	}
	

	@PostMapping("/postshopping")
	public String saveShopping(@RequestBody Shopping s) {
		shoppingService.saveShopping(s);
		return "data saved ";

}

}
