package com.vtech.project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.project.Model.Items;

import com.vtech.project.Servicve.ItemsService;

@CrossOrigin("*")
@RestController
public class ItemsController {

	@Autowired
	ItemsService itemsService;

	@GetMapping("/getitems")
	public ArrayList<Items> getItems() {
		return itemsService.getAllItems();
	}

	@PostMapping("/postitems")
	public String saveItems(@RequestBody Items i) {
		itemsService.saveItems(i);
		return "data saved ";

	}

	@GetMapping("/items/{id}")
	public Optional<Items> findId(@PathVariable(name = "id", required = true) Long id) {
		return itemsService.findById(id);
	}

	@GetMapping("/itemsn/{name}")
	public List<Items> findByName(@PathVariable(name = "name", required = true) String name) {
		return itemsService.findByName(name);
	}

	@PutMapping("/putitems")
	public String updateItems(@RequestBody Items i) {
		itemsService.updateItems(i);
		return "Updated ";
	}

	@PutMapping("/putitems/{id}")
	public String updateItemById(@PathVariable Long id, @RequestBody Items updatedItem) {
		// Assuming ItemsService is a Spring service handling business logic
		// Implement the logic to update the item identified by the given ID
		itemsService.updateItemById(id, updatedItem);

		// Return a response indicating success
		return "Item with ID " + id + " updated successfully";
	}

	@DeleteMapping("/removeitems/{itemsId}")
	public String removeItem(@PathVariable Long itemsId) {
		itemsService.removeItem(itemsId);
		return "Item with ID " + itemsId + " has been removed.";
	}

}
