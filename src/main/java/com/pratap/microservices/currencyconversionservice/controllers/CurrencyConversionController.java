package com.pratap.microservices.currencyconversionservice.controllers;

import com.pratap.microservices.currencyconversionservice.model.CurrencyConversionResponseModel;
import com.pratap.microservices.currencyconversionservice.model.CurrencyExchangeResponseModel;
import com.pratap.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
@Slf4j
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    private Environment environment;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponseModel calculateCurrencyConversion(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") BigDecimal quantity){

        log.info("Executing calculateCurrencyConversion() with from={}, to={} and quantity={}", from, to, quantity);

        log.info("Going to call CurrencyExchangeProxy");
        CurrencyExchangeResponseModel currencyExchangeResponseModel = currencyExchangeProxy.retrieveExchangeValue(from, to);

        CurrencyConversionResponseModel currencyConversionResponseModel = new CurrencyConversionResponseModel(currencyExchangeResponseModel.getId(),
                from, to, quantity, currencyExchangeResponseModel.getConversionMultiple(),
                quantity.multiply(currencyExchangeResponseModel.getConversionMultiple()));
//        String port = environment.getProperty("local.server.port");
        currencyConversionResponseModel.setEnvironment(currencyExchangeResponseModel.getEnvironment());
        return currencyConversionResponseModel;
    }
}
