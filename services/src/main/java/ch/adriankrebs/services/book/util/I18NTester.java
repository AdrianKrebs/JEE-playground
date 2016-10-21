package ch.adriankrebs.services.book.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Adrian on 10/21/2016.
 */
public class I18NTester {

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}


