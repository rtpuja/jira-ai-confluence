package com.ai.confluence.javaaiconfluence.controller;


import com.ai.confluence.javaaiconfluence.service.ConfluenceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confluence")
public class ConfluenceController {

    @Autowired
    private ConfluenceService confluenceService;

    /**
     * Endpoint to push Swagger documentation to Confluence.
     * This method retrieves the OpenAPI JSON from the local endpoint and pushes it to Confluence.
     *
     * @return a confirmation message indicating the operation was successful.
     */
    @Operation(
            summary = "Push Swagger documentation to Confluence",
            description = "Retrieves OpenAPI JSON from the local endpoint and pushes it to Confluence."
    )
    @PostMapping("/push")
    public String pushToConfluence() {
        confluenceService.pushSwaggerDocToConfluence();
        return "Pushed to Confluence";
    }
}

