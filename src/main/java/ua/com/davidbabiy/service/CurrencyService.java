package ua.com.davidbabiy.service;

import ua.com.davidbabiy.entity.Currency;

import java.io.IOException;

public interface CurrencyService {

    Currency getEur() throws IOException, InterruptedException;
    Currency getUsd() throws IOException, InterruptedException;
    Currency getPln() throws IOException, InterruptedException;

}
