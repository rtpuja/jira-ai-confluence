package com.ai.confluence.javaaiconfluence.model;

import lombok.Data;

/**
 * Represents a user in the system.
 * This class contains basic user information such as ID, name, and email.
 * It uses Lombok's @Data annotation to generate boilerplate code like getters, setters, and toString.
 */
@Data
public class User {
    /**
     * The unique identifier of the user.
     */
    private Long id;

    /**
     * The name of the user.
     */
    private String name;

    /**
     * The email address of the user.
     */
    private String email;
}