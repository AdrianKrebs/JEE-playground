package ch.adriankrebs.services.book.util;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Adrian on 9/22/2016.
 */
public class FunctionalProgramming {


    public static void main(String[] args) {

        String test = "tester";

        check((h, l) -> h > l, 5); // x1


        /*
        METHOD REFERENCES
         */

        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();

        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);



        /*
        CONDITIONALLY REMOVE
         */

        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]


        /*
        REPLACE ALL
         */

        List<String> stringList = new ArrayList<>();
        stringList.add("Magician");
        stringList.add("Assistant");
        System.out.println(stringList); // [Magician, Assistant]
        stringList.removeIf(s -> s.startsWith("A"));
        System.out.println(stringList); // [Magician]






        /*
        SUPPLIER
         */

        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);


        /*
        CONSUMER
         */
        Consumer<String> consumer = System.out::println;
        consumer.accept("Adrian");

        HashMap<String, String> map = new HashMap<>();
        BiConsumer<String, String> biConsumer = map::put;
        biConsumer.accept("Adrian", "geile Siech");


        /*
        PREDICATE
         */

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());


        /*
        FUNCTIONS
         */

        BiFunction<String, String, String> biFunction1 = String::concat;
        BiFunction<String, String, String> biFunction2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(biFunction1.apply("baby ", "chick")); // baby chick
        System.out.println(biFunction2.apply("baby ", "chick")); // baby chick


        /*
        UNARY, BINARY OPERATOR
         */

        BinaryOperator<String> binaryOperator = String::concat;
        BinaryOperator<String> binaryOperator1 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(binaryOperator.apply("baby ", "chick")); // baby chick
        System.out.println(binaryOperator1.apply("baby ", "chick")); // baby chick


        /*
        STREAMS
         */

        // findAny, findFirst work also on infinite streams
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp

        //match
        List<String> stringList1 = Arrays.asList("monkey", "2", "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(stringList1.stream().anyMatch(pred)); // true
        System.out.println(stringList1.stream().allMatch(pred)); // false
        System.out.println(stringList1.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true

        //reduction
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (firstString, secondString) -> firstString + secondString);
        String wordShorter = stream.reduce("", String::concat); //method reference at its best
        System.out.println(word); // wolf

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4); // caution here: define the type of the Stream!
        System.out.println(numbers.reduce(1, (a, b) -> a * b));
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::print); // 3
        threeElements.reduce(op).ifPresent(System.out::print); // 90


        //collect
        Collector<StringBuilder, StringBuilder, StringBuilder> collector = Collector.of(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        StringBuilder collectedWord = stream.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);

        TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set); // [f, l, o, w]
        Set<String> unsortedSet = stream.collect(Collectors.toSet());
        System.out.println(unsortedSet); // [f, w, l, o]


        //how streams work
        Stream<Integer> infiniteIntegers = Stream.iterate(1, x -> x + 1);
        infiniteIntegers.limit(5)
                .peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);
        // prints 11233455


        //primitive streams
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(String::length);

        IntStream intStream12 = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = intStream12.average();

        //Statistics
        IntSummaryStatistics stats = intStream.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        System.out.println(stats.getMax() - stats.getMin());

        //boolean supplier
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier);

    }

    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10)) // x2
            System.out.println("too high");
        else System.out.println("ok");
    }


    public interface Climb {
        boolean isTooHigh(int height, int limit);
    }

         /*
        OPTIONAL
         */

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

}
