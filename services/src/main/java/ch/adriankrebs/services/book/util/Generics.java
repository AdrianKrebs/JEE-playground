package ch.adriankrebs.services.book.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Created by Adrian on 9/23/2016.
 */
public class Generics {

    static class Sparrow extends Bird {
    }

    static class Bird {
    }

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<>();
       // birds.add(new Sparrow()); // DOES NOT COMPILE
       // birds.add(new Bird()); // DOES NOT COMPILE

        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);
        //addSound(objects); --> cant add object to wildcarded list
        Collection<String> tester = new ArrayList<>();
        tester.remove("onetwo");



    }

    public static void addSound(List<String> list)
    {
        list.add("quack");
    }
}
