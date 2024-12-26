package com.vtech.project.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.vtech.project.Model.Address;

import com.vtech.project.Servicve.AddressService;


@CrossOrigin("*")
@RestController
class AddressController {
	
		@Autowired
		AddressService addressService;

		@GetMapping("/getaddress")
		public ArrayList<Address> getAddress() {
			return addressService.getAllAddress();
		}
		

		@PostMapping("/postaddress")
		public String saveAddress(@RequestBody Address a) {
			addressService.saveAddress(a);
			return "data saved ";
		}

}
