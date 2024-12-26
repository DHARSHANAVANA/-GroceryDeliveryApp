package com.vtech.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vtech.project.Model.Shopping;
@Repository

public interface ShoppingRepository extends CrudRepository<Shopping, Long>{

}
