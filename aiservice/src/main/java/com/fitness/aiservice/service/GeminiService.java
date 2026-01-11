package com.fitness.aiservice.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;


@Service
public class GeminiService {
    private final WebClient webClient;
     
    @Value("${gemini.api.url}")
    private String apiUrl = "geminiApiUrl";
    @Value("${gemini.api.key}")
    private String apiKey = "geminiApiKey";    
    
    public GeminiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }

    public String generateContent(String prompt) {
        Map<String,Object> requestBody = Map.of("contents",
         new Object[] { Map.of("parts", new Object[] { Map.of("text", prompt) } ) });
        // Implementation for calling Gemini API
        // This is a placeholder implementation
        
        return webClient.post()
                .uri(apiUrl + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
