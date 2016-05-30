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
 *
 * "POST /books" with a bunch of book information might create a new book, and respond with the new URL identifying that book: "/books/5".

 "PUT /books/5" would have to either create a new book with the id of 5, or replace the existing book with ID 5.

 Methods can also have the property of "idempotence" in that (aside from error or expiration issues) the side-effects of N > 0 identical requests is the same as for a single request.
 The methods GET, HEAD, PUT and DELETE share this property. Also, the methods OPTIONS and TRACE SHOULD NOT have side effects, and so are inherently idempotent.

 PUT is idempotent, The POST method is not idempotent,
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
