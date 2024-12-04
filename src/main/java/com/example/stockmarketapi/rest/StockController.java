package com.example.stockmarketapi.rest;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketapi.async.asyncClient.asyncMarketCapClient;
import com.example.stockmarketapi.async.asyncClient.asyncQuoteClient;
import com.example.stockmarketapi.async.client.asyncClient.asyncMarketCapClient;
import com.example.stockmarketapi.async.client.asyncClient.asyncQuoteClient;
import com.example.stockmarketapi.model.marketApiResponse;
import com.example.stockmarketapi.model.quoteApiResponse;
import com.example.stockmarketapi.rest.response.StockResponse;
import com.example.stockmarketapi.sync.client.ApiMarketCapClient;
import com.example.stockmarketapi.sync.client.ApiQuoteClient;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RequestMapping("/stocks")
@RestController
@RequiredArgsConstructor
@Slf4j
public class StockController {

    private final ApiQuoteClient apiQuoteClient;

    private final ApiMarketCapClient apiMarketCapClient;

    private final asyncQuoteClient asyncquoteClient;

    private final asyncMarketCapClient asyncmarketCapClient;

    /**
     * Fetches stock information including current price and market cap.
     *
     * @param symbol the company name/stock symbol (e.g., AAPL, TSLA)
     * @return a {@link StockResponse} with stock details
     */

    @GetMapping("/currentPrice")
    public StockResponse getStockDetails(@RequestParam @NonNull String symbol) {

        quoteApiResponse quoteData = apiQuoteClient.getQuote(symbol);

        marketApiResponse marketCapData = apiMarketCapClient.getMarketCap(symbol);

        return new StockResponse(
                symbol,
                marketCapData.getName(),
                quoteData.getCurrentPrice(),
                quoteData.getTodayHigh(),
                quoteData.getTodayLow(),
                quoteData.getPreviousClose(),
                marketCapData.getMarketCap(),
                LocalDateTime.now()
        );
    }

    /**
     * Fetches stock information including current price and market cap
     * Asynchronously.
     * 
     * @param symbol the company name/stock symbol (e.g., AAPL, TSLA)
     * @return a {@link StockResponse} with stock details
     */

    @Async
    @GetMapping("/currentPriceAsync")
    public Mono<StockResponse> getStockDetailsAsync(@RequestParam @NonNull String symbol) {

        Mono<quoteApiResponse> quoteResponse = asyncquoteClient.getQuoteAsync(symbol);

        Mono<marketApiResponse> marketResponse = asyncmarketCapClient.getMarketCapAsync(symbol);

        return Mono.zip(quoteResponse, marketResponse).map(tuple -> {
            quoteApiResponse quoteMono = tuple.getT1(); 
            marketApiResponse marketCapMono = tuple.getT2(); 

            return new StockResponse(
                symbol,
                marketCapMono.getName(),
                quoteMono.getCurrentPrice(),
                quoteMono.getTodayHigh(),
                quoteMono.getTodayLow(),
                quoteMono.getPreviousClose(),
                marketCapMono.getMarketCap(),
                LocalDateTime.now()
            );
        });
        
    }

}
