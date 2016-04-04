package services.book.control;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by Adrian on 2/9/2016.
 */
@SessionScoped
public class StockfighterBackingBean implements Serializable{

    // some POJO logic here... may to prepare request or store response in db

    int movieId;
    String movieName;
    String actors;

    public int getMovieId()
    {
        return movieId;
    }

    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public String getActors()
    {
        return actors;
    }

    public void setActors(String actors)
    {
        this.actors = actors;
    }


}
