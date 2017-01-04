package ch.adriankrebs.services.book.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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


class BoxDemo {

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();

        /*
        The generic method addBox defines one type parameter named U.
        Generally, a Java compiler can infer the type parameters of a generic method call. Consequently, in most cases, you do not have to specify them.
        Both methods work:
         */
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }

    private static class Box <T> {


        public <T> void set(T whatever) {

        }

        public T get() {


            return null;
        }

    }

}

