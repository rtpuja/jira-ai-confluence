//package com.ai.confluence.javaaiconfluence.publisher;
//
//import org.springframework.stereotype.Service;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.Base64;
//
//@Service
//public class ConfluencePublisher {
//
//    private static final String CONFLUENCE_URL = "https://poojakumawat75.atlassian.net/wiki/rest/api/content";
//    private static final String SPACE_KEY = "JavaDocPor";
//    private static final String PAGE_TITLE = "Spring Boot API Documentation";
//
//    // Replace with your Atlassian email and API token
//    private static final String EMAIL = "pooja.kumawat75@example.com";
//    private static final String API_TOKEN = "ATATT3xFfGF0YncM9zQLHWXG6kerrfvGIXmzWBLgNJQwhOPBrpI0KHazBF_UIlL2zQTOWzFQnw8ELRPuDeXLctvV94Imz9Qa10Zk02oHUHG9RDy0ZTJeY3JqRl6_oGz6iTIIBZFx2XnNAk1VY5ostH7oX8H4PNrNmwWy7wM9Heu3RCj1r4JlacQ=B8234DFF";
//
//    public static void main(String[] args) throws Exception {
//        // Step 1: Call your local Swagger OpenAPI endpoint
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest swaggerRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8084/v3/api-docs"))
//                .build();
//
//        HttpResponse<String> swaggerResponse = client.send(swaggerRequest, HttpResponse.BodyHandlers.ofString());
//        String openApiJson = swaggerResponse.body();
//
//        // Step 2: Wrap it in an HTML <pre> block or format it
//        String pageContent = "<h1>Spring Boot API Documentation</h1><pre>" + openApiJson + "</pre>";
//
//        // Step 3: Build Confluence page JSON
//        String bodyJson = String.format("""
//            {
//              "type": "page",
//              "title": "%s",
//              "space": { "key": "%s" },
//              "body": {
//                "storage": {
//                  "value": "%s",
//                  "representation": "storage"
//                }
//              }
//            }
//            """, PAGE_TITLE, SPACE_KEY, pageContent.replace("\"", "\\\"").replace("\n", ""));
//
//        // Step 4: Push to Confluence
//        String auth = Base64.getEncoder().encodeToString((EMAIL + ":" + API_TOKEN).getBytes());
//
//        HttpRequest confluenceRequest = HttpRequest.newBuilder()
//                .uri(URI.create(CONFLUENCE_URL))
//                .header("Authorization", "Basic " + auth)
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
//                .build();
//
//        HttpResponse<String> confluenceResponse = client.send(confluenceRequest, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println("Status: " + confluenceResponse.statusCode());
//        System.out.println("Response: " + confluenceResponse.body());
//    }
//}
//
