package com.example.stockmarketapi.model;
import java.io.Serializable;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@Getter
public class quoteApiResponse implements Serializable
{

    @JsonProperty("c")
    public Double currentPrice;

    @JsonProperty("h")
    public Double todayHigh;

    @JsonProperty("l")
    public Double todayLow;

    @JsonProperty("o")
    public Double todayOpen;

    @JsonProperty("pc")
    public Double previousClose;

    @JsonProperty("t")
    public Long t;

    private final static long serialVersionUID = -3306600476681228065L;

}