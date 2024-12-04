package com.example.stockmarketapi.sync.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.stockmarketapi.model.quoteApiResponse;

@Service
public class ApiQuoteClient {

    private final RestClient restClient;
    private final String API_KEY;
    private final String BASE_URL;

    public ApiQuoteClient(RestClient restclient, @Value("${finnhub.api.key}") String API_KEY, @Value("${finnhub.api.base-url}") String BASE_URL) {
        this.restClient = restclient;
        this.API_KEY = API_KEY;
        this.BASE_URL = BASE_URL;
    }

    public quoteApiResponse getQuote(String symbol) {
        String url = String.format("%s/quote?symbol=%s&token=%s", BASE_URL, symbol, API_KEY);

        System.out.println("Request URL: " + url);
        
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(quoteApiResponse.class);
    }

}
