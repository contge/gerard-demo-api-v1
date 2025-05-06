package com.gerard.gerard_demo_api_v1.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.gerard.gerard_demo_api_v1.model.User;
import com.gerard.gerard_demo_api_v1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.getAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("users", users.getContent());
        response.put("currentPage", users.getNumber());
        response.put("totalItems", users.getTotalElements());
        response.put("totalPages", users.getTotalPages());
        response.put("hasNext", users.hasNext());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.update(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email-nativo/{email}")
    public ResponseEntity<User> getUserByEmailNativo(@PathVariable String email) {
        User user = userService.getByEmailNativo(email);
        return ResponseEntity.ok(user);
    }
}