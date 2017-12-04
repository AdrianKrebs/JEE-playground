package ch.adriankrebs.services.book.bfh.patterns;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by Adrian on 10/24/2017.
 */

public class Client {

    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());

    @Inject
    private CountryService service; //Two interfaces --> beans.xml decides which one is used

    public void main(@Observes ContainerInitialized event) {
        LOGGER.info(service.getCountryName("CH"));
    }

//    public void observer(@Observes LoginEvent loginEvent) {
//        LOGGER.info("LoginEvent caught");
//    }
}
