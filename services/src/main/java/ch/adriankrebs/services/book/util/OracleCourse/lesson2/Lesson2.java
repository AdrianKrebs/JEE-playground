/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package ch.adriankrebs.services.book.util.OracleCourse.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.adriankrebs.services.book.data.Person;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson2
{

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws IOException
     */
    public void runExercises() throws IOException
    {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
        System.out.println("finished");
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to lower case and print them out.
     */
    private void exercise1()
    {
        List<String> list = Arrays.asList(
            "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        List<String> lowerCaseList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        lowerCaseList.forEach(System.out::println);
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an odd length
     */
    private void exercise2()
    {
        List<String> list = Arrays.asList(
            "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        List<String> lowerCaseList = list.stream().map(String::toLowerCase).filter(s -> s.length() % 2 != 0).collect(Collectors.toList());
        lowerCaseList.forEach(System.out::println);
    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single string, where each word is separated by a hyphen (-). Print the resulting string.
     */
    private void exercise3()
    {
        List<String> list = Arrays.asList(
            "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        /* YOUR CODE HERE */
        System.out.println(list.stream().skip(1).limit(3).collect(Collectors.joining("-")));
    }

    /*
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4() throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("SonnetI.txt"), StandardCharsets.UTF_8))
        {
            /* YOUR CODE HERE */

            System.out.println(reader.lines().count());

        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with no duplicates contained in the file. Print the words.
     *
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("SonnetI.txt"), StandardCharsets.UTF_8))
        {
            /* YOUR CODE HERE */
            List<String> wordList = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).distinct().collect(Collectors.toList());

            System.out.println(wordList);
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from the file, converted to lower-case and with duplicates removed, which is sorted by natural order. Print the contents of the list.
     */
    private void exercise6() throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("SonnetI.txt"), StandardCharsets.UTF_8))
        {
            /* YOUR CODE HERE */
            List<String> wordList = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());

            System.out.println(wordList);
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get("SonnetI.txt"), StandardCharsets.UTF_8))
        {
            /* YOUR CODE HERE */

            List<String> wordList = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).map(String::toLowerCase).distinct().sorted((s1,s2)-> s1.length() - s2.length()).collect(Collectors.toList());
            System.out.println(wordList);

        }
    }

    public void flatMap() {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);


        List<Set<String>> teamLanguagesList = team.stream().
                map(d -> d.getLanguages()).collect(Collectors.toList());;
        teamLanguagesList.forEach(System.out::println);

        List<String> teamLanguagesFlattened = team.stream().
                map(d -> d.getLanguages()).
                flatMap(l -> l.stream()).
                collect(Collectors.toList());
        teamLanguagesFlattened.forEach(System.out::println);
    }

    public void createMap() {

        List<Developer> developersList = new ArrayList<>(Arrays.asList(new Developer("csharp")));
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person("peter")));


            Map<String, Set<String>> rksProLb = developersList.stream()
                    .collect(Collectors.toMap(
                            // Map from lb id.
                            dev -> dev.name,
                            // To the rks itself.
                            dev -> dev.getLanguages()));

    }


    public class Developer {

        private String name;
        private Set<String> languages;

        public Developer(String name) {
            this.languages = new HashSet<>();
            this.name = name;
        }

        public void add(String language) {
            this.languages.add(language);
        }

        public Set<String> getLanguages() {
            return languages;
        }
    }


    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If file access does not work
     */
    public static void main(String[] args) throws IOException
    {
        Lesson2 lesson = new Lesson2();
        lesson.runExercises();
    }
}
