package com.ai.confluence.javaaiconfluence.service.impl;

import com.ai.confluence.javaaiconfluence.model.User;
import com.ai.confluence.javaaiconfluence.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementation of the {@link UserService} interface.
 * Provides in-memory storage and management of user data.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * A map that acts as an in-memory store for user data, where the key is the user ID.
     */
    private final Map<Long, User> userStore = new HashMap<>();

    /**
     * Counter to generate unique IDs for new users.
     */
    private Long idCounter = 1L;

    /**
     * Retrieves all users from the in-memory store.
     *
     * @return a list of all {@link User} objects.
     */
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    /**
     * Retrieves a user by their ID from the in-memory store.
     *
     * @param id the ID of the user to retrieve.
     * @return the {@link User} object with the specified ID, or null if not found.
     */
    @Override
    public User getUserById(Long id) {
        return userStore.get(id);
    }

    /**
     * Creates a new user, assigns a unique ID, and stores it in the in-memory store.
     *
     * @param user the {@link User} object to create.
     * @return the created {@link User} object with the assigned ID.
     */
    @Override
    public User createUser(User user) {
        user.setId(idCounter++);
        userStore.put(user.getId(), user);
        return user;
    }
}