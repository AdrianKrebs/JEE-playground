package ch.adriankrebs.services.book.control.PokerAlgorithmus;

import java.util.List;

/**
 * Created by Adrian on 3/21/2016.
 */
public class PokerImpl implements Poker {

    @Override
    public int poker(List<String []> hands) {
        // spec: return the highest ranking hand
       // HashMap<String [],Integer> sortedHands = new HashMap<>();
      //  hands.forEach(hand -> sortedHands.put(hand,hand_rank(hand)));
        return 0;
    }

    @Override
    public int[] hand_rank(String [] hand) {
        //return a value indicating the ranking of ahand


        return new int [] {1,2};

    }

    // declare hands as constants

    // create compare method which takes a collection of pokerhands as an input parameter

    // create unittests for both of this methods

    // watch video and adapt the stuff to java

    // you may create a GUI animation for your different hands in JS/Angular








}
