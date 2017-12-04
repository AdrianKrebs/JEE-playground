package ch.adriankrebs.services.book.bfh.patterns;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Adrian on 10/23/2017.
 */
public class CountryServiceLocal implements CountryService {

    private static final Logger LOGGER = Logger.getLogger(CountryServiceLocal.class
            .getName());


    @Override
    public String getCountryName(String countryCode) {
        LOGGER.info("local");
        Locale locale = new Locale("",countryCode);
        String countryName = locale.getDisplayCountry();

        if (countryName.isEmpty()) {
            return "no result found";
        } else {
            return countryName;
        }
    }

    public static void main(String[] args) {
        CountryServiceLocal service = new CountryServiceLocal();
        System.out.println(service.getCountryName("CH"));
    }
}
