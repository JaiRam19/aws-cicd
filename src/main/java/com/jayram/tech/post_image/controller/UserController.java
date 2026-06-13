package com.jayram.tech.post_image.controller;

import com.jayram.tech.post_image.dto.UserAccountDto;
import com.jayram.tech.post_image.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-image/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserAccountDto> createAccount(UserAccountDto userAccountDto) {
        return new ResponseEntity<>(userService.createAccount(userAccountDto), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<UserAccountDto> getAccount(@RequestHeader("username") String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserAccountDto>> getAllAccounts() {
        return new ResponseEntity<>(userService.getAllAccounts(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestHeader("username") String username) {
        return new ResponseEntity<>(userService.deleteByUsername(username), HttpStatus.OK);
    }



}
