package com.vtech.project.Servicve;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.project.Model.Items;
import com.vtech.project.Model.User;
import com.vtech.project.Repository.ItemsRepository;
import com.vtech.project.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
  private ItemsRepository itemsRepository;
  
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isEmailExists(String email) {
        return userRepository.findByUserEmail(email) != null;
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public void addItemForUser(long userId, long itemId) {
        // Retrieve the user entity by ID
        User user = userRepository.findById(userId).orElse(null);

        // Retrieve the item entity by ID
        Items item = itemsRepository.findById(itemId).orElse(null);

        // Check if both user and item exist
        if (user != null && item != null) {
            // Check if the association already exists
            if (!user.getItems().contains(item)) {
                // Add the item to the user's collection of items
                user.getItems().add(item);
                userRepository.save(user); // Save the user entity to persist changes
            } else {
                // Handle scenario where the association already exists
                // You can throw an exception, log a message, or perform any other appropriate action
                // For example:
                throw new RuntimeException("Association already exists between user and item");
            }
        } else {
            // Handle scenario where either user or item does not exist
            // You can throw an exception, log a message, or perform any other appropriate action
        }
    }
    public User getUserById(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }
    public User getUserById1(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

}