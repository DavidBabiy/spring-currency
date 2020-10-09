package ua.com.davidbabiy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.davidbabiy.entity.Currency;
import ua.com.davidbabiy.service.CurrencyService;

import java.io.IOException;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    //GET
    public Currency getUsdRate() {
        try {
            return currencyService.getUsd();
        } catch (IOException | InterruptedException e) {
            return new Currency().setStatus("500 Internal Error");
        }
    }

    //GET
    public Currency getEurRate() {
        try {
            return currencyService.getEur();
        } catch (IOException | InterruptedException e) {
            return new Currency().setStatus("500 Internal Error");
        }
    }

    //GET
    public Currency getPlnRate() {
        try {
            return currencyService.getPln();
        } catch (IOException | InterruptedException e) {
            return new Currency().setStatus("500 Internal Error");
        }
    }

}
