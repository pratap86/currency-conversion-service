package com.pratap.microservices.currencyconversionservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyExchangeResponseModel {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
