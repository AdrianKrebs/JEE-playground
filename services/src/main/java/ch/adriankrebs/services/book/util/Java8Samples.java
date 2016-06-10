package ch.adriankrebs.services.book.util;

import ch.adriankrebs.services.book.data.Author;
import ch.adriankrebs.services.book.data.Book;
import ch.adriankrebs.services.book.data.Condition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by U116523 on 07.04.2016.
 */
public class Java8Samples {


    // Function.apply
    // Consumer
    // Functional Interface
    // Lambda
    // DateTime
    //
    public int calcSomething(List<Author> authors) {
        // useless method for some Java8 sample snippets

        List <Book> booksWithHighPrice = authors.stream().flatMap(a -> a.getBooksWrittenByAuthor().stream()).filter(b
                -> b
                .getPrice() > 100)
                .collect(Collectors.toList());

        Integer sumOfAllBookIds = booksWithHighPrice.stream().map(Book::getCondition).filter(c -> c.getName().equals
                ("new")).map
                (Condition::getId).reduce(0, Integer::sum);


        return  sumOfAllBookIds.intValue();
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }






    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>(Arrays.asList(new Person()));
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

    }

    public static class Person {

        public enum Sex {
            MALE, FEMALE
        }

        String name;
        LocalDate birthday;
        Sex gender;
        String emailAddress;

        public int getAge() {
          return 6;
        }

        public void printPerson() {
            System.out.println("test");
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public Sex getGender() {
            return gender;
        }
    }


}
