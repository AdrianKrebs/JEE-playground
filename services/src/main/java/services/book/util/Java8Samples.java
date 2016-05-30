package services.book.util;

import services.book.data.Author;
import services.book.data.Book;
import services.book.data.Condition;

import java.util.List;
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





    public static void main(String[] args) {

    }

}
