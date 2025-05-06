package com.gerard.gerard_demo_api_v1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gerard.gerard_demo_api_v1.model.User;

public interface UserService {
    Page<User> getAll(Pageable pageable);
    User create(User user);
    User getById(Long id);
    User update(Long id, User user);
    void delete(Long id);
    User getByEmail(String email);
    User getByEmailNativo(String email);
}
