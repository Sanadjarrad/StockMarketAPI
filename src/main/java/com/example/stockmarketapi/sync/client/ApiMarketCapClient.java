package com.example.stockmarketapi.sync.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.stockmarketapi.model.marketApiResponse;

@Service
public class ApiMarketCapClient {

    private final RestClient restClient;
    private final String API_KEY;
    private final String BASE_URL;

    public ApiMarketCapClient(RestClient restClient, @Value("${marketcap.api.key}") String API_KEY, @Value("${marketcap.api.base-url}") String BASE_URL) {
        this.restClient = restClient;
        this.API_KEY = API_KEY;
        this.BASE_URL = BASE_URL;
    }

    public marketApiResponse getMarketCap(String symbol) {
        String url = String.format("%s/?ticker=%s", BASE_URL, symbol);

        System.out.println("Request URL: " + url);

        return restClient.get()
                .uri(url)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                .retrieve()
                .body(marketApiResponse.class);
    }

}
