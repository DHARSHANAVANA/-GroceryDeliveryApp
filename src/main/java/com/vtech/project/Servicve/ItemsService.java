package com.vtech.project.Servicve;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vtech.project.Model.Items;
import com.vtech.project.Repository.ItemsRepository;

@Service
public class ItemsService {
	@Autowired
	ItemsRepository itemsRepository;
	public ArrayList<Items> getAllItems() {
		return (ArrayList<Items>) itemsRepository.findAll();
	}
	public void saveItems(Items i) {
		itemsRepository.save(i);
	}
	public Optional<Items> findById(Long id){
		return itemsRepository.findById(id);
	}
	public List<Items> findByName(String name){
		return itemsRepository.findByName(name);
	}
	public void updateItems(Items i) {
		Items temp = itemsRepository.findById(i.getItemsId()).get();
		temp.setItemsName(i.getItemsName());
		temp.setPrice(i.getPrice());
		temp.setDescription(i.getDescription());
		temp.setImage(i.getImage());
		
		itemsRepository.save(temp);
		
	}

    public void updateItemById(Long id, Items updatedItem) {
        // Retrieve the existing item from the database
        Items existingItem = itemsRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        
        // Update the existing item with the data from the updatedItem
        existingItem.setItemsName(updatedItem.getItemsName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setImage(updatedItem.getImage());
       

        // Save the updated item back to the database
        itemsRepository.save(existingItem);
    }

	 public void removeItem(Long itemsId) {
	        itemsRepository.deleteById(itemsId);
	    }
}
