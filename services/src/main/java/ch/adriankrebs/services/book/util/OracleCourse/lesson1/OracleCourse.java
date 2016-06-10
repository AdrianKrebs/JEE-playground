/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.adriankrebs.services.book.util.OracleCourse.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Adrian
 */
public class OracleCourse
{

 
   public void lambdasTest() throws IOException
   {
    List<String> myList = new ArrayList<>();
    
    // old way to do it
    myList.forEach(s -> System.out.println(s));
    
    // method reference
    myList.forEach(System.out::println);
    
    // new collection method -> remove all elemtents where length is 0
    myList.removeIf(s-> s.length() == 0);
    
    // new collection method -> upperCase
    myList.replaceAll(s -> s.toUpperCase());
    //method refernce
    myList.replaceAll(String::toUpperCase);
   
    //new List Interface Method
    
    // comparetor directly in method -> sorting string by length here
    myList.sort((x,y)-> x.length() -y.length());
    
    //Logger class
    
    // rather than passing a value we can pass a behaviour
    // they can be used wherever a functional interface type is used
    // method and cunstructor references can be used as shorthand
    //lambda expressions can refer to effectively final local variables from the surrounding scope 
    //-> important for multi threading
    //lambda expression is not associated with a class -> its an anonymous function -> there is no object
    
//    logger.finest(createComplexMessage());
//    logger.finest(()->creteaComplexMessage());
    
// buffered reader read lines of text in file 
    // we pass that to flatmap which concatenates each word of each line into a single stream == inputstream
    //filter for length null
    //collect
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       List <String> output = reader.lines()
           .flatMap(line -> Stream.of(line.split(",")))
           .filter(word -> word.length()>0)
           .collect(Collectors.toList());
               
    
       // skip first two line of file and then get the next two ---> lines 2 to 4 are read
       // is optimized.. think of when you have like 1000 file lines to read
       String outputString = reader.
           lines()
           .skip(2)
           .limit(2)
           .collect(Collectors.joining());
       
       
       // optinal avoid null reference
       
       OptionalDouble maximum = IntStream.iterate(0, i -> i+2)
           .limit(100)
           .average();
       
       
       //if a result is present, print it out
       maximum.ifPresent(x -> System.out.print(Double.toString(x)));
    
       // streams provide straight forward way for functional style
       // --> chain together method calls
       // streams of objects or primitive types -> boxing, unboxing problem
       // source --> possible intermediate operations --> terminal operations (provide optional)
     
       //find the longeset line in a file
       
       String longest = Files.lines(Paths.get("text.txt")).
           sorted((x,y) -> y.length()-x.length()).
           findFirst().get();
       
       // problem solved but big files take a long time and a lot of resources
       
       longest = "";
       String s = "";
       while    ((s = reader.readLine()) != null)
       if (s.length() > longest.length())
           longest = s;
       
       // simple but serial, not thread safe
       // not functional
       
       //recursive approach
       Path input = Paths.get("text.txt");
       
       String longesLine = Files.lines(input).reduce((x, y) -> {
           if (x.length() > y.length())
               return x;
           return y;
       } ).get();
     
       // even simpler -->

    

          
       
   }
    
    public static void main(String[] args)
    {
        // TODO code application logic here
       
        
    }
    
}
