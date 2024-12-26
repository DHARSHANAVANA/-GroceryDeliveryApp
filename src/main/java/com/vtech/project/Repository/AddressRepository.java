package com.vtech.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vtech.project.Model.Address;
import com.vtech.project.Model.Admin;
@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}
