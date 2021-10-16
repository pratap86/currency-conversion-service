package com.pratap.microservices.currencyconversionservice.proxy;

import com.pratap.microservices.currencyconversionservice.model.CurrencyExchangeResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponseModel retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);
}
