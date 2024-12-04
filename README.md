# StockMarketAPI

StockMarketAPI is a Spring Boot application that provides RESTful services for stock market data, combining information from multiple APIs to deliver a comprehensive and enriched response format. It supports both synchronous and asynchronous operations for enhanced performance and scalability.

## Features

- Richer API Format: Combines data from two distinct APIs—Market Cap and Stock Quotes—to deliver detailed and enriched responses.
- Synchronous and Asynchronous Clients: Fetch stock data in real-time using both sync and async modes.
- REST API Endpoints: Expose market data and stock quotes through easy-to-use RESTful APIs.
- Exception Handling: Global exception handling for robust error management.
- Custom Models: Well-defined response models for API interaction.

## Requirments

- Java: Java 11 or later
- Maven: For dependency management and building the application

## Setup and Installation

1. Clone the repository:

```
git clone https://github.com/Sanadjarrad/StockMarketAPI.git
cd stockmarketapi
```
2. Build the project using Maven: 

```
./mvnw clean install
```

3. Run the Application (or directly from your IDE):

```
./mvnw spring-boot:run
```

4. The application will start at **http://localhost:8080**.

## API Endpoints

## Market Data and Stock Quotes
The StockMarketAPI enriches its responses by combining data from two APIs:

### - Market Cap API: Provides market capitalization data for a given company.
### - Stock Quote API: Offers real-time stock quote information.

## Unified API Endpoint
### GET http://localhost:8080/stocks/currentPrice?symbol='companySymbol' : 
Fetches a combination of market cap and stock quote information for a specific company, returning an enriched and unified response format.

### GET http://localhost:8080/stocks/currentPriceAsync?symbol='companySymbol' :
Fetches a combination of market cap and stock quote information for a specific company, This endpoint returns the same response as 'currentPrice',
However, it uses Spring's WebClient (as oppposed to RestClient), which is a non-blocking reactive client to make HTTP requests.

