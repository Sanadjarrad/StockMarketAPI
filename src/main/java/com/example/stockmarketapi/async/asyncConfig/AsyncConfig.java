package com.example.stockmarketapi.async.asyncConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AsyncConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
