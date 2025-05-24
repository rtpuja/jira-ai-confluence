package com.ai.confluence.javaaiconfluence.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class ConfluenceService {

    @Value("${confluence.api.url}")
    private String confluenceUrl;

    @Value("${confluence.space.key}")
    private String spaceKey;

    @Value("${confluence.page.title}")
    private String pageTitle;

    @Value("${confluence.auth.email}")
    private String email;

    @Value("${confluence.auth.token}")
    private String apiToken;

    private final WebClient webClient = WebClient.create();

    public void pushSwaggerDocToConfluence() {
        // 1. Call local OpenAPI endpoint
        String openApiJson = webClient.get()
                .uri("http://localhost:8084/v3/api-docs")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // 2. Build Confluence page payload
        String html = "<h1>Spring Boot API Docs</h1><pre>" + openApiJson + "</pre>";
        String payload = String.format("""
        {
            "type": "page",
            "title": "%s",
            "space": { "key": "%s" },
            "body": {
                "storage": {
                    "value": "%s",
                    "representation": "storage"
                }
            }
        }
        """, pageTitle, spaceKey, html.replace("\"", "\\\""));

        // 3. Send to Confluence
        String authHeader = "Basic " + "cG9vamEua3VtYXdhdDc1QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBZbmNNOXpRTEhXWEc2a2VycmZ2R0lYbXpXQkxnTkpRd2hPUEJycEkwS0hhekJGX1VJbEwyelFUT1d6RlFudzhFTFJQdURlWExjdHZWOTRJbXo5UWExMFprMDJvSFVIRzlSRHkwWlRKZVkzSnFSbDZfb0d6NmlUSUlCWkZ4MlhuTkFrMVZZNW9zdEg3b1g4SDRQTnJObXdXeTd3TTlIZXUzUkNqMXI0SmxhY1E9QjgyMzRERkY=";

        WebClient.ResponseSpec response = webClient.post()
                .uri(confluenceUrl)
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(payload), String.class)
                .retrieve();

        String result = response.bodyToMono(String.class).block();
        System.out.println("Confluence response:\n" + result);
    }
}

