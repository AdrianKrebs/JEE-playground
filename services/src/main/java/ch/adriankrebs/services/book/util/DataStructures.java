package ch.adriankrebs.services.book.util;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by Adrian on 8/5/2016.
 */
public class DataStructures {


    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();
        List s1 = new ArrayList();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s1.add("a");
        if (s1.remove("a")) {
            if (s1.remove("a")) {
                s1.remove("b");
            } else {
                s1.remove("c");
            }
        }
        System.out.println(s1);

        // --> c


   /*     ArrayList's remove(Object ) method removes the first occurence of the given element and returns true if found.
        It does not remove all occurences of the element. In this case, the first call to s1.remove("a"); will remove only the first "a"
        and return true, the second call to remove("a") will remove the second "a" and return true.
                Finally, the call to remove("b") will remove "b". Therefore, only "c" will be left in the list.
*/

        /*
        order
        ---------------------
        Both an array and ArrayList are ordered and have indexes.


        */



        /*
        equality
        -----------------------------
        An array does not override equals() and so uses object equality. ArrayList does
        override equals() and defines it as the same elements in the same order.


         */

        int[] eqTester = {1, 2, 3};
        int[] eqTester2 = {1, 2, 3};

        System.out.println(eqTester == eqTester2); // false


        /*
        searching
        ---------------------------------
         an array must be sorted for binarySearch() to return a meaningful result.


           Remember that numbers sort before
           letters and strings sort alphabetically. This makes 30 come before 8. A binary search
           correctly finds 8 at index 2 and 3A at index 1. It cannot find 4F but notices it should
           be at index 2. The rule when an item isn’t found is to negate that index and subtract 1.
           Therefore, we get –2–1, which is –3.

           Here a more mathematical way of seeing it, though not really complicated. IMO much clearer as informal ones:

            The question is, how many times can you divide N by 2 until you have 1? This is essentially saying, do a binary search (half the elements) until you found it. In a formula this would be this:

            1 = N / 2x
            multiply by 2x:

            2x = N
            now do the log2:

            log2(2x)    = log2 N
            x * log2(2) = log2 N
            x * 1         = log2 N
            this means you can divide log N times until you have everything divided. Which means you have to divide log N ("do the binary search step") until you found your element.
         */


        List<String> hex = Arrays.asList("30", "8", "3A", "FF");
        Collections.sort(hex);
        int x = Collections.binarySearch(hex, "8");
        int y = Collections.binarySearch(hex, "3A");
        int z = Collections.binarySearch(hex, "4F");
        System.out.println(x + " " + y + " " + z);


        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);
        // returns -1 or undefined ( hoppy should be places at the 0 index, * -1, -1)

        Comparator<String> cCorrect = Comparator.naturalOrder();
        int indexWorks = Collections.binarySearch(names, "Hoppy", cCorrect);
        System.out.println(indexWorks);
        // returns 1


        // QUEUES AND STACKS


        Queue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // nul

        Deque<Integer> d = new ArrayDeque<>();
        d.add(1);
        d.push(2);
        d.pop();
        d.offerFirst(3);
        d.remove();
        System.out.println("--------------------------------"+d);



        /*
        COMPARABLE AND COMPARATOR
         */


        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.addAll(Arrays.asList(new Rabbit(3), new Rabbit(4)));
//        Comparator<Rabbit> c2 = (r1, r2) -> r1.id - r2.id;
//        Collections.sort(rabbits, c2);
//        Comparator comp = Comparator.reverseOrder();
//        Collections.sort(rabbits, comp);

        // sorting in Streams
        // sorted takes no arguments or a function
        //rabbits.stream().sorted(Comparator.comparing((r)-> r.id)).forEach(System.out::println);
        rabbits.stream().map(r -> r.id).sorted().forEach(System.out::println);



        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        Comparator<Duck> testC = (d1, d2) -> d1.getName().compareTo(d2.getName());
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));


        ducks.stream().sorted(byWeight.thenComparing((d1, d2) -> d1.getName().compareTo(d2.getName()))); // if two elements are equal then use this comparator
        // different ways of sorting
        Collections.sort(ducks); // comparable
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
        java.util.Collections.sort(ducks, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        java.util.Collections.sort(ducks, Comparator.comparing(Duck::getName));

        Map<String, List<Integer>> collect = ducks.stream().collect(Collectors.groupingBy(Duck::getName, Collectors.mapping(Duck::getWeight, Collectors.toList())));



        /*
        TREESET
         */


        Set<Rabbit> rabbit = new TreeSet<>(new Comparator<Rabbit>() {
            public int compare(Rabbit r1, Rabbit r2) {
                return r1.id = r2.id;
            }
        });

        // pass comperator as parameter or implement comparable within rabbit
        rabbit.addAll(Arrays.asList(new Rabbit(3), new Rabbit(4)));

        HashMap<Integer, Integer> tester = new HashMap<>(10);

        Sorted s11 = new Sorted(88, "a");
        Sorted s22 = new Sorted(55, "b");
        TreeSet<Sorted> t1 = new TreeSet<>();
        t1.add(s11);
        t1.add(s22);
        TreeSet<Sorted> t2 = new TreeSet<>(s11);
        t2.add(s11);
        t2.add(s22);
        System.out.println(t1 + " " + t2);



        /*
        NEW METHODS ON MAP INTERFACE
          */

        BiFunction<String, String, String> mapper = (v1, v2)
                -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride
        favorites.putIfAbsent("Jenny", "alreadyThere"); // i.e usage in a cache


        // Navigatable Map --> Threadsafe

        NavigableMap<String, String> mymap = new TreeMap<String, String>();
        mymap.put("a", "apple");
        mymap.put("b", "boy");
        mymap.put("c", "cat");
        mymap.put("aa", "apple1");
        mymap.put("bb", "boy1");
        mymap.put("cc", "cat1");

        mymap.pollLastEntry(); //LINE 1
        mymap.pollFirstEntry(); //LINE 2

        NavigableMap<String, String> tailmap = mymap.tailMap("bb", false); //LINE 3 p whose keys are greater than (or equal to, if {@code inclusive} is true)
        //therefore we get c and cc back. c is polled then

        System.out.println(tailmap.pollFirstEntry()); //LINE 4
        System.out.println(mymap.size()); //LINE 5

        NavigableMap<String, Integer> navigableMap = new TreeMap<String, Integer>();

        navigableMap.put("X", 500);
        navigableMap.put("B", 600);
        navigableMap.put("A", 700);
        navigableMap.put("T", 800);
        navigableMap.put("Y", 900);
        navigableMap.put("Z", 200);

        System.out.printf("Descending Set  : %s%n", navigableMap.descendingKeySet());

        System.out.printf("Floor Entry  : %s%n", navigableMap.floorEntry("L"));

        System.out.printf("First Entry  : %s%n", navigableMap.firstEntry());

        System.out.printf("Last Key : %s%n", navigableMap.lastKey());

        System.out.printf("First Key : %s%n", navigableMap.firstKey());

        System.out.printf("Original Map : %s%n", navigableMap);

        System.out.printf("Reverse Map : %s%n", navigableMap.descendingMap());


        Deque<Integer> d2 = new ArrayDeque<>();
        d2.push(1);
        d2.push(2);
        d2.push(3);
        System.out.println(d2.remove());
        System.out.println(d2.remove());
        System.out.println(d2.remove());

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for (int i = 324; i <= 328; i++) {
            s.add(i);
        }
        subs = (TreeSet) s.subSet(326, true, 328, true); //from inlusive, to inclusive
        //        subs.add(329); // key out of range exception
        System.out.println(s + " " + subs);
        SortedSet<Rabbit> naviSet = new TreeSet<>((a,b) -> b.id - a.id); // descending --> a.id -b.id ascending
        naviSet.add(new Rabbit(1));
        naviSet.add(new Rabbit(2));
        System.out.println("Order of navigableSet: "+naviSet);




        Integer floor = s.floor(330);// greatest element in this set less than or equal to
        Integer ceiling = s.ceiling(330);// greatest element in this set less than or equal to
        System.out.println(ceiling); // null in this case
        System.out.println(floor);
        SortedSet<Integer> integers = s.tailSet(326);// subset greater or equal value
        System.out.println(integers);




        /*
        BINARY SEARCH
        input must be sorted set
        divides tree by two every iteration
         */

        String[] sa = {"a", "aa", "aaa", "aaaa"};
        Arrays.sort(sa);
        String search = "";
        System.out.println("Item found at index: (if < -1 not found)"+Arrays.binarySearch(sa, "aaaa"));


    }


}

class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
    private int num;
    private String text;

    Sorted(int n, String t) {
        this.num = n;
        this.text = t;
    }

    public String toString() {
        return "" + num;
    }

    public int compareTo(Sorted s) {
        return text.compareTo(s.text);
    }

    public int compare(Sorted s1, Sorted s2) {
        return s1.num - s2.num;
    }
}


class Rabbit {
    int id;

    public Rabbit(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "id=" + id +
                '}';
    }
}


class Duck implements Comparable<Duck> {
    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }
}
