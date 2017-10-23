package ch.adriankrebs.services.book.bfh.patterns;

import java.util.Locale;

/**
 * Created by Adrian on 10/23/2017.
 */
public class CountryService implements ICountryService {
    @Override
    public String getCountryName(String countryCode) {
        Locale locale = new Locale("",countryCode);
        String countryName = locale.getDisplayCountry();

        if (countryName.isEmpty()) {
            return "no result found";
        } else {
            return countryName;
        }
    }

    public static void main(String[] args) {
        CountryService service = new CountryService();
        System.out.println(service.getCountryName("CH"));
    }
}
