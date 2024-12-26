package com.vtech.project.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.project.Model.Admin;

import com.vtech.project.Servicve.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {
	@Autowired
	AdminService adminServices;

	@GetMapping("/getadmin")
	public ArrayList<Admin> getAdmin() {
		return adminServices.getAllAdmin();
	}
	@PostMapping("/admin/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
	    String emailId = request.get("emailId");
	    String password = request.get("password");

	    if (emailId == null || password == null) {
	        return ResponseEntity.badRequest().body("Email and password are required");
	    }

	   Admin admin = adminServices.getAdminByEmail(emailId);
	
	    if (admin == null || !password.equals(admin.getPassword())) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	    }
	    // Construct the response JSON object with the user ID
	    Map<String, Object> responseData = new HashMap<>();
	    responseData.put("userId", admin.getAdminId());
	    responseData.put("message", "Login successful");

	    return ResponseEntity.ok(responseData);
	}
	
	}
	
