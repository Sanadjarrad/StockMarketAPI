package com.example.stockmarketapi.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Getter;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@Getter
public class marketApiResponse implements Serializable
{

    @JsonProperty("ticker")
    public String ticker;

    @JsonProperty("name")
    public String name;

    @JsonProperty("market_cap")
    public Long marketCap;

    @JsonProperty("updated")
    public Integer updated;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private final static long serialVersionUID = -1454242852185796113L;
}
