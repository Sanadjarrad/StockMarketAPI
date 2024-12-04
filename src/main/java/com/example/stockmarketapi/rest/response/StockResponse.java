package com.example.stockmarketapi.rest.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StockResponse {

    private String symbol;
    private String companyName;
    private double currentPrice;
    private double todaysHigh;
    private double todaysLow;
    private double previousClose;
    private long marketCap;
    private LocalDateTime date;
}

