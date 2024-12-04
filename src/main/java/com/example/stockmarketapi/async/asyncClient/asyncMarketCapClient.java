package com.example.stockmarketapi.async.asyncClient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.stockmarketapi.exception.InvalidApiKeyException;
import com.example.stockmarketapi.model.marketApiResponse;

import reactor.core.publisher.Mono;

@Service
public class asyncMarketCapClient {

    private final WebClient webClient;
    private final String API_KEY;
    private final String BASE_URL;

    public asyncMarketCapClient(WebClient webClient,  @Value("${marketcap.api.base-url}") String BASE_URL, @Value("${marketcap.api.key}") String API_KEY) {
        this.webClient = webClient;
        this.BASE_URL = BASE_URL;
        this.API_KEY = API_KEY;
    }

    public Mono<marketApiResponse> getMarketCapAsync(String symbol) throws InvalidApiKeyException {
        String url = String.format("%s/?ticker=%s&token=%s", BASE_URL, symbol, API_KEY);

         return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new InvalidApiKeyException("Invalid API key or unauthorized access")))
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Server error occurred")))
                .bodyToMono(marketApiResponse.class);
    }


}
