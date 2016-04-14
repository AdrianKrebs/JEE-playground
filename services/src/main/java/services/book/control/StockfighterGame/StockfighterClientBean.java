package services.book.control.StockfighterGame;


import services.book.data.Book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.Serializable;

/**
 *
 * Controller for my fist attempts to complete a level in the stockfighter coding challenge
 * Created by Adrian on 2/9/2016.
 */
@SessionScoped
public class StockfighterClientBean implements StockfighterMngmtService, Serializable
{

    @Inject
    StockfighterBackingBean bean;

    Client client;
    WebTarget target;

    private static String BASE_URL = "someurl";
    private static String AUTH_CODE = "some authentification stuff";

    @PostConstruct
    public void init()
    {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/movieplex7/webresources/movies/");

    }

    @PreDestroy
    public void destroy()
    {
        client.close();

    }

    public String[] getStocks()
    {

        return target.request().get(String[].class);

    }

    //make use of the Client and WebTarget isntaces to obtain the currently selected Movie object
    public String getMovie()
    {
        String m = target
                .path("{movie}") // adds movie to the current REST endpoint URL
                .resolveTemplate("movie", bean.getMovieId()).request() // bount to a concrete value
                .get(String.class);
        return m;
    }

    //new in JTA 2.1
    // This annotation provides the ability to control the transactional boundaries on CDI managed beans
    @Transactional
    public void deleteMovie()
    {
        target.path("{movieId}")
                .resolveTemplate("movieId", bean.getMovieId())
                .request()
                .delete();

    }

    public void placeOrder()
    {
        // may prepare here a request like quantity and min,max price range for your order you wanna place

        Book m = new Book();
        m.setIsbn(bean.getMovieId());
        m.setName(bean.getMovieName());

        // register a moviewriter which then provides conversation from the Movie plain old java object (POJO) into JSON form
    }

}
