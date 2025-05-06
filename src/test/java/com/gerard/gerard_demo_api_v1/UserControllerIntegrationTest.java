package com.gerard.gerard_demo_api_v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

import com.gerard.gerard_demo_api_v1.model.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAndGetUser() {
        User user = new User();
        user.setName("Gerard");
        user.setEmail("gerard@email.com");

        ResponseEntity<User> postResponse = restTemplate.postForEntity("/users", user, User.class);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        Long userId = postResponse.getBody().getId();

        ResponseEntity<User> getResponse = restTemplate.getForEntity("/users/" + userId, User.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals("Gerard", getResponse.getBody().getName());
    }
}
