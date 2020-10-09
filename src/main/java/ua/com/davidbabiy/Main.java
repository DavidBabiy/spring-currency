package ua.com.davidbabiy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.davidbabiy.controller.CurrencyController;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ua.com.davidbabiy.configuration");
        CurrencyController currencyController = context.getBean(CurrencyController.class);
        for (String arg: args) {
            switch (arg) {
                case "USD": {
                    System.out.println(currencyController.getUsdRate());
                    break;
                }
                case "PLN": {
                    System.out.println(currencyController.getPlnRate());
                    break;
                }
                case "EUR": {
                    System.out.println(currencyController.getEurRate());
                    break;
                }
            }

        }

    }

}
