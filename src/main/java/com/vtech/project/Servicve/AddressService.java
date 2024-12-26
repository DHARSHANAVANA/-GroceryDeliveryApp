package com.vtech.project.Servicve;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.Address;
import com.vtech.project.Repository.AddressRepository;


@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public ArrayList<Address> getAllAddress() {
		return (ArrayList<Address>) addressRepository.findAll();
	}
	public void saveAddress(Address p) {
		addressRepository.save(p);
	}
	
}
