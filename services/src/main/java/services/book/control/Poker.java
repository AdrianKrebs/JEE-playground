package services.book.control;

import java.util.List;

/**
 * Created by Adrian on 3/22/2016.
 */
public interface Poker {

    int poker(List<String[]> hands);

    int [] hand_rank(String[] hand);


}
