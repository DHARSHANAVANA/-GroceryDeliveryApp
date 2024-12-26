package com.vtech.project.Servicve;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.Admin;
import com.vtech.project.Repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public ArrayList<Admin> getAllAdmin() {
        return (ArrayList<Admin>) adminRepository.findAll();
    }

    public Admin getAdminByEmail(String emailId) {
        return adminRepository.findByEmailId(emailId);
    }
}