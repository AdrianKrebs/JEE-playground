package ch.adriankrebs.services.book.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by U116523 on 22.02.2017.
 */
public class Tester {
    String memberVar = "hmm";

    class Testeroni {
        public void changeVar() {
            memberVar = "werewer";
            Tester.this.memberVar = "sdffsf";
        }
    }

    public void innerClassAccessTester() {
        final String localVar = "teststest";
        Testeroni testeroni = new Tester().new Testeroni();
        Tester.this.memberVar = "13"; // access outer variables when instantiated like before

        class LocalInner {

            public void letMeChangeVarFromLocalClass() {
                memberVar = "works";
                System.out.println("works since effectifely final" + localVar);
            }

        }

    }

    public static void main(String[] args) {

        /*
         * Collection
         */

        Hashtable<String, String> hs = new Hashtable<>(); // vanishing rare to use hastable. not able to store null values, no guarantee
        LinkedHashSet<String> lhs = new LinkedHashSet<>(); // predictable order
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();  //predictable order maintains the elements in the order of their insertion time.
        TreeMap<String, String> tm = new TreeMap<>(); // Red-Black Tree based on navigableSet, sorted according to comparator. predicatable order
        HashMap<String, String> hm = new HashMap<>(); // no guarantee of the order
        Set<String> hashset = new HashSet<>(); // unordered since set...
        hashset.add(null); //allowed
        SortedMap<String,String> sortiert = new TreeMap<>(); // natural ordering of its keys or you could provide your own comperator

        hm.put(null, null); // null is allowed for keys as well as for values
        tm.put("test", null); // null keys not allowed

        /*
         * LOCALE
         */
        Locale locale = new Locale("en", "US");
        //        ResourceBundle rb = ResourceBundle.getBundle("test.MyBundle", locale);
        //        rb.getStringArray("key");
        //        rb.getString("key");
        //        Object key = rb.getObject("key");

        ITrade newTradeChecker = (String t) -> t.length() == 10;

        /*
         * PECS --> Producer extends, consumer super
         */

        // EXTENDS --> upper bound

        // allowed declaration --> all subclasses of Child and Child itself
        List<? extends Child> producer = new ArrayList<Child>(Arrays.asList(new GrandChild("test"), new Child("tester2"))); // upper bound Parent not allowed
        List<? extends Child> producerChild = new ArrayList<Child>();
        List<? extends Child> producerGrandChild = new ArrayList<GrandChild>();

        //allowed writing --> nothing
        //You can't add any object to List<? extends T> because you can't guarantee what kind of List it is

        //allowed reading --> Child or subclasses of it, You cant read a grandChild because it could point to other subclass
        Parent parent = producer.get(0);
        GrandChild c = (GrandChild) producer.get(1); //list could contain all subclasses of C but must contain subclass of Parent
        System.out.println(parent);

        // SUPER --> lower bound

        // Allowed declaration --> all superclasses of Child and Child itself
        List<? super Child> consumer = new ArrayList<>(); // Child
        List<? super Child> consumerChild = new ArrayList<Child>(); // Child
        List<? super Child> consumerParent = new ArrayList<Parent>(); // Parent
        List<? super Child> consumerObject = new ArrayList<Object>(); // Object

        // allowed writing --> all subclasses of Child are conform to the lists
        consumerChild.add(new Child("test"));
        consumerChild.add(new GrandChild("test2"));

        consumerParent.add(new Child("test"));
        consumerParent.add(new Child("test"));

        // allowed reading --> nothing is guaranteed except that it is an object or subclass of object
        GrandChild c13 = (GrandChild) consumerChild.get(1); // you arent guaranteed to get a specific class, even object is possible. so casting/ instanceOf is important
        Object testerObj = consumerChild.get(0);
        System.out.println(testerObj);

        Map<String, List<Double>> testerMap = new HashMap<>();
        testerMap.put("a", Arrays.asList(new Double(123)));
        testerMap.put("b", Arrays.asList(new Double(1234)));
        testerMap.computeIfAbsent("z", a -> new ArrayList<>()).add(new Double(1123)); // if key is absent create new arraylist and add 1123

        BiFunction<String, String, Integer> bi = (a, b) -> a.length() + b.length(); //1

        System.out.println("result of bifunction: " + bi.apply("testest", "etstset"));

        /*
         * INNER CLASSES
         */

        //new Testeroni().new TestInner(); will not compile if inner is static

        // ACCESSES
        // member (class level) inner classes have access all variables of the outer class and are instantiated by outer.new Inner(); inner variables accesss with Inner.this.x
        // local (method level) inner classes have access to final or effectifely final classes
        // anonymous inner classes don't have access to outer variables but outer has access to inner

        //DATE/TIME

        ZonedDateTime yesterday = ZonedDateTime.of(LocalDateTime.of(2017, 4, 5, 10, 12), ZoneId.systemDefault());
        ZonedDateTime zonedNow = ZonedDateTime.now();
        Duration durPlus = Duration.between(yesterday, zonedNow); // second minus first
        Duration durMinus = Duration.between(zonedNow, yesterday);
        Period perMinus = Period.between(LocalDate.now(), LocalDate.of(2017, 4, 5));
        System.out.println(durMinus); // PT-25H  --> level hour till second
        System.out.println(perMinus); // no T for Period --> P-1D --> level day
        System.out.println(durPlus);

    }

    private void process(String name, Double d) {

    }

    static class Parent {
        private String test;

        public Parent(String test) {
            this.test = test;
        }

        public String getTest() {
            return test;
        }

        @Override
        public String toString() {
            return test;
        }
    }

    static class Child extends Parent {
        public Child(String test) {
            super(test);
        }
    }

    static class GrandChild extends Child {
        public GrandChild(String test) {
            super(test);
        }
    }

    interface defaultTester {

        public default String getId() {
            return "123123";
        }

        public abstract void tester(); // is public abstract anyway, abstract is redundant in this case
    }

    interface secondI extends defaultTester {
        //String getId();
        //static String getAuthor(); // static methods need a body
        // public abstract static getName(); abstract is not allowed either

        //        default String getId(){ // just defines new default behaviour
        //            return "1231";
        //        }

        String getId(); // also works

    }

    class Testing implements secondI {

        @Override
        public String getId() {
            return null;
        }

        @Override
        public void tester() {

        }

    }
}

class myLovelyTesterThread extends Thread {

    byte letMeTestTheTrick(Object object) {
        if (object != null) {
            return 127;
        }
        return -128;
    }

}

class A extends Thread {
    static protected int i = 0;

    public void run() {
        for (; i < 5; i++)
            System.out.println("Hello");
    }
}

class TestClass213 extends A {
    public void run() {
        for (; i < 5; i++)
            System.out.println("World");
    }

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new A();
        Thread t2 = new TestClass213();
        t2.start();
        t1.start(); // can't be determined
    }
}

interface imInterface1 {
    public default String ö() {
        return "tester";
    }
}

interface imInterface2 {
    public static String imTester() {
        return "tester";
    } // since  default and static interface methods have a body they are not functional interfcaes
}

class Impl implements imInterface1, imInterface2 {

    public String tester() {
        return "blabla";
    }
}

@FunctionalInterface //marker interface
interface ITrade {
    public boolean check(String string);
}

class Address implements Comparable<Address> {
    String street;
    String zip;

    public Address(String street, String zip) {
        this.street = street;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public int compareTo(Address o) {
        int x = this.zip.compareTo(o.zip); // always ascending --> lowest postal code first, shortest string first
        return x == 0 ? this.street.compareTo(o.street) : x;
    }
}

class TestClass132 {
    public static void main(String[] args) {
        ArrayList<Address> al = new ArrayList<>();
        al.add(new Address("dupont dr", "28217"));
        al.add(new Address("sharview cir", "28217"));
        al.add(new Address("yorkmont ridge ln", "11223"));
        Collections.sort(al);
        Map<String, List<String>> collect =
                al.stream().collect(Collectors.groupingBy(a -> a.zip, Collectors.mapping(a -> a.getStreet(), Collectors.toList())));
        Map<String, List<Address>> collect1 = al.stream().collect(Collectors.groupingBy(a -> a.getStreet())); // sure this works
        System.out.println(collect);

        //TODO cyclic barrier --> why to add merger in sample?

        for (Address a : al)
            System.out.println(a.street + " " + a.zip);
    }
}

class Solver {
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;
        Worker(int row) { myRow = row; }
        public void run() {
            while (true) { // !done()
               // processRow(myRow);

                try {
                    barrier.await(); // N++
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }
    }

    public Solver(float[][] matrix) {
        data = matrix;
        N = matrix.length; // size of threads that must wait for each other
        barrier = new CyclicBarrier(N, // when all rows are processed, the supplied Runnable is executed, or without a parameter
                new Runnable() {
                    public void run() {
                        //merge rows
                    }
                });
        for (int i = 0; i < N; ++i)
            new Thread(new Worker(i)).start();

    }
}


/**
 * Equal objects must produce the same hash code as long as they are equal, however unequal objects need not produce distinct hash
 * codes.
 */
class GoodOne {
    int theval;

    public int hashCode() {
        return theval % 3; // does not do need distinct for unequal object
    }

    public boolean equals(Object obj) {
        try {
            return this == obj ? true : (theval % 3 == 0 && ((GoodOne) obj).theval % 3 == 0) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }
}
