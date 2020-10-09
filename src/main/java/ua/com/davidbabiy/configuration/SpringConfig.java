package ua.com.davidbabiy.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Configuration
@ComponentScan(basePackages = "ua.com.davidbabiy")
public class SpringConfig {

    private final String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=";


    @Bean
    HttpClient httpClient() {
       return HttpClient.newBuilder().build();
    }

    @Bean
    @Primary
    HttpRequest httpRequestUsd() throws URISyntaxException {
        return HttpRequest
                .newBuilder(new URI(url + "USD&json"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
    }

    @Bean
    HttpRequest httpRequestEur() throws URISyntaxException {
        return HttpRequest
                .newBuilder(new URI(url + "EUR&json"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
    }

    @Bean
    HttpRequest httpRequestPln() throws URISyntaxException {
        return HttpRequest
                .newBuilder(new URI(url + "PLN&json"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
    }

    @Bean
    Gson gson() {
        return new Gson();
    }

}
