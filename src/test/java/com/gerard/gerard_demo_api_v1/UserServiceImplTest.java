package com.gerard.gerard_demo_api_v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gerard.gerard_demo_api_v1.exception.ResourceNotFoundException;
import com.gerard.gerard_demo_api_v1.model.User;
import com.gerard.gerard_demo_api_v1.repository.UserRepository;
import com.gerard.gerard_demo_api_v1.service.UserServiceImpl;

public class UserServiceImplTest {
    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testGetById_UserExists() {
        User user = new User(1L, "Gerard", "gerard@email.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getById(1L);

        assertEquals("Gerard", result.getName());
    }

    @Test
    void testGetById_UserNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.getById(2L));
    }
}
