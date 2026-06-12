package com.jayram.tech.post_image.repository;

import com.jayram.tech.post_image.dto.UserAccountDto;
import com.jayram.tech.post_image.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    private final List<UserAccountDto> users = new ArrayList<>();

    public UserAccountDto save(UserAccountDto userAccountDto) {
        users.add(userAccountDto);
        return userAccountDto;
    }

    public List<UserAccountDto> findAll() {
        return users;
    }

    public Optional<UserAccountDto> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username))
                .findFirst()
                .or(Optional::empty);
    }

    public void deleteByUsername(String username) {
        UserAccountDto user = findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        users.remove(user);
    }
}
