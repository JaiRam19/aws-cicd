package com.jayram.tech.post_image.service;

import com.jayram.tech.post_image.dto.UserAccountDto;
import com.jayram.tech.post_image.exception.ResourceNotFoundException;
import com.jayram.tech.post_image.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccountDto createAccount(UserAccountDto userAccountDto) {
        // Here you would typically convert the DTO to an entity, save it using the repository, and then convert it back to a DTO.
        // For simplicity, let's assume the repository returns the saved entity directly as a DTO.
        return userRepository.save(userAccountDto);
    }

    public UserAccountDto findByUsername(String username) {
        // This method would retrieve a user account by its ID.
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    public List<UserAccountDto> getAllAccounts() {
        // This method would retrieve all user accounts.
         List<UserAccountDto> users = userRepository.findAll();
         if (users.isEmpty()) {
             throw new ResourceNotFoundException("No users found");
         }
         return users;
    }

    public String deleteByUsername(String username) {
        // This method would delete a user account by its ID.
        userRepository.deleteByUsername(username);
        return "User with username: " + username + " has been deleted successfully.";
    }
}
