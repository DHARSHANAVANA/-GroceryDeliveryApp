package com.vtech.project.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.vtech.project.Model.Items;
@Repository
public interface ItemsRepository extends CrudRepository<Items, Long>{
	@Query("SELECT u FROM Items u WHERE u.itemsName =:name ")
	List<Items> findByName(@Param("name") String name);

	
}
