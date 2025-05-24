package com.ai.confluence.javaaiconfluence.controller;

import com.ai.confluence.javaaiconfluence.model.User;
import com.ai.confluence.javaaiconfluence.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing users.
 * Provides endpoints for retrieving, creating, and managing user data.
 */
@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Endpoints for managing users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of {@link User} objects.
     */

    @Operation(summary = "Get all users from the system. Returns a list of all registered users.")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the {@link User} object with the specified ID.
     */
    @Operation(
            summary = "Get a user by ID",
            description = "Retrieves a user from the system by their unique identifier. Returns the user details if found, or null if the user does not exist.")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Creates a new user.
     *
     * @param user the {@link User} object to create.
     * @return the created {@link User} object.
     */
    @Operation(summary = "Create a new user in the system and return the created user object")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id   the ID of the user to update.
     * @param user the {@link User} object containing updated information.
     * @return the updated {@link User} object.
     */
}