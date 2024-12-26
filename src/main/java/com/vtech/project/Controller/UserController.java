package com.vtech.project.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.project.Model.Items;
import com.vtech.project.Model.User;
import com.vtech.project.Servicve.UserService;

@CrossOrigin("*")
@RestController

public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getuser")
	public List<User> getAllUser() {
		return userService.getAllUsers();

	}



	@GetMapping("getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("putuser/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User user) {
		User existingUser = userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
		existingUser.setUserName(user.getUserName());
		existingUser.setUserEmail(user.getUserEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setItems(user.getItems());
		userService.updateUser(existingUser);
	}

	@DeleteMapping("deleteuser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@PostMapping("user/checkemail")
	public ResponseEntity<Map<String, Boolean>> checkEmailExists(@RequestBody Map<String, String> requestBody) {
		String userEmail = requestBody.get("userEmail");
		boolean exists = userService.isEmailExists(userEmail);
		Map<String, Boolean> response = new HashMap<>();
		response.put("exists", exists);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/postuser")
	public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
		String userEmail = user.getUserEmail();
		if (userService.isEmailExists(userEmail)) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Email already exists. User data not stored.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}

		userService.saveUser(user);
		Map<String, String> response = new HashMap<>();
		response.put("message", "User registered successfully");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("user/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
	    String userEmail = request.get("userEmail");
	    String userPassword = request.get("userPassword");

	    if (userEmail == null || userPassword == null) {
	        return ResponseEntity.badRequest().body("Email and password are required");
	    }

	    User user = userService.getUserByEmail(userEmail);

	    if (user == null || !userPassword.equals(user.getUserPassword())) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	    }

	    // Construct the response JSON object with the user ID
	    Map<String, Object> responseData = new HashMap<>();
	    responseData.put("userId", user.getUserId());
	    responseData.put("message", "Login successful");

	    return ResponseEntity.ok(responseData);
	}
    @PostMapping("/users/{userId}/items/{itemId}")
    public void addItemForUser(@PathVariable("userId") long userId, @PathVariable("itemId") long itemId) {
        userService.addItemForUser(userId, itemId);
    }
    @GetMapping("users/{userId}/cart")
    public ResponseEntity<?> getUserCartItems(@PathVariable long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user.getItems());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    
    
    @DeleteMapping("/users/{userId}/cart/{itemId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable long userId, @PathVariable long itemId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            boolean removed = user.getItems().removeIf(item -> item.getItemsId() == itemId);
            if (removed) {
                userService.updateUser(user);
                return ResponseEntity.ok("Item removed from cart successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found in the cart");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    
    
}
