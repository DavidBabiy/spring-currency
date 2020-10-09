package ua.com.davidbabiy.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.davidbabiy.entity.Currency;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CurrencyServiceImp implements CurrencyService {

    private final HttpClient httpClient;

    private final HttpRequest httpRequestUsd;

    private final HttpRequest httpRequestEur;

    private final HttpRequest httpRequestPln;

    private final Gson gson;

    @Autowired
    CurrencyServiceImp(HttpClient httpClient,
                       HttpRequest httpRequestUsd,
                       @Qualifier("httpRequestPln") HttpRequest httpRequestPln,
                       @Qualifier("httpRequestEur") HttpRequest httpRequestEur,
                       @Qualifier("gson") Gson gson) {
        this.httpClient = httpClient;
        this.httpRequestUsd = httpRequestUsd;
        this.httpRequestPln = httpRequestPln;
        this.httpRequestEur = httpRequestEur;
        this.gson = gson;
    }


    public Currency getUsd() throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = sendRequest(httpRequestUsd);
        String res = httpResponse.body().replaceAll("\\s+","");
        return gson.fromJson(res.substring(1, res.length() - 1), Currency.class);
    }

    public Currency getEur() throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = sendRequest(httpRequestEur);
        String res = httpResponse.body().replaceAll("\\s+","");
        return gson.fromJson(res.substring(1, res.length() - 1), Currency.class);
    }

    public Currency getPln() throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = sendRequest(httpRequestPln);
        String res = httpResponse.body().replaceAll("\\s+","");
        return gson.fromJson(res.substring(1, res.length() - 1), Currency.class);
    }

    private HttpResponse<String> sendRequest(HttpRequest httpRequest) throws IOException, InterruptedException {
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}
