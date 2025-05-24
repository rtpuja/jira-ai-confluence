package com.ai.confluence.javaaiconfluence.service;

import com.ai.confluence.javaaiconfluence.model.User;

import java.util.List;

/**
 * Service interface for managing users.
 * Provides methods for retrieving, creating, and managing user data.
 */
public interface UserService {

    /**
     * Retrieves a list of all users.
     *
     * @return a list of {@link User} objects.
     */
    List<User> getAllUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the {@link User} object with the specified ID, or null if not found.
     */
    User getUserById(Long id);

    /**
     * Creates a new user.
     *
     * @param user the {@link User} object to create.
     * @return the created {@link User} object.
     */
    User createUser(User user);
}