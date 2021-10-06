package com.pratap.microservices.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class CurrencyConversionResponseModel {

    @NonNull
    private Long id;

    @NonNull
    private String from;

    @NonNull
    private String to;

    @NonNull
    private BigDecimal quantity;

    @NonNull
    private BigDecimal conversionMultiple;

    @NonNull
    private BigDecimal totalCalculatedAmount;

    private String environment;
}
