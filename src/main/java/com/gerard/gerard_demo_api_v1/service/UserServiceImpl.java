package com.gerard.gerard_demo_api_v1.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.gerard.gerard_demo_api_v1.exception.ResourceNotFoundException;
import com.gerard.gerard_demo_api_v1.model.User;
import com.gerard.gerard_demo_api_v1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.buscarPorEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }

    @Override
    public User getByEmailNativo(String email) {
        return userRepository.buscarPorEmailNativo(email)
            .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }
}