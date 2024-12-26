package com.vtech.project.Repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtech.project.Model.Items;
import com.vtech.project.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserPassword(String userPassword);
	User findByUserEmail(String userEmail);
	    Optional<User> findByuserPassword(String userPassword);
	    Optional<User>findByuserEmail(String userEmail);
	   

	

}