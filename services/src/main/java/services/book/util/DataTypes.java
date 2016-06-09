package services.book.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U116523 on 19.04.2016.
 */
public class DataTypes {

    public static void main(String[] args) {

        // prints binary
        System.out.println(Integer.toBinaryString(0b100001011));

        // prints decimal
        System.out.println(0b100001011);

        // underscore in literal numbers -> not allowed before prefix. at the end and at the beginning A-F in hex
        // prefix hex -> 0x
        // prefix bin -> 0b
        // prefix oct -> 0
        System.out.println(0x4_13);

        // ------ Difference primitives and reference variables----------
        //      The basic difference is that primitive
        //        variables store the actual values, whereas reference variables store the addresses of the
        //        objects they refer to.

        boolean b1, b2, b3, b4, b5, b6; // line 1
        b1 = b2 = b3 = true; // allowed because same type


//   (superclass)                                        Number
                            //                   __________/\__________
                            //                /       |      |       \
//   (concrete subclasses)               Integer   Long    Float   Double






    }


    // AUTOBOXING


    private static void autoboxing() {

        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li.add(i);

        //  Although you add the int values as primitive types, rather than Integer objects, to li,
        // the code compiles. Because li is a list of Integer objects, not a list of int values,
        // you may wonder why the Java compiler does not issue a compile-time error.
        // The compiler does not generate an error because it creates an Integer object from i and adds the object to li.
        // Thus, the compiler converts the previous code to the following at runtime:

        List<Integer> li2 = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li2.add(Integer.valueOf(i));
    }


    // UNBOXING

    // why does this work? Operators do not apply to Integers??!
    public static int sumEvenQuestion(List<Integer> li) {
        int sum = 0;
        for (Integer i: li)
            if (i % 2 == 0)
                sum += i;
        return sum;
    }


    //Because the remainder (%) and unary plus (+=) operators do not apply to Integer objects, you may wonder why the Java compiler compiles the method without issuing any errors. The compiler does not generate an error because it invokes the intValue method to convert an Integer to an int at runtime:

    public static int sumEvenSolution(List<Integer> li) {
        int sum = 0;
        for (Integer i : li)
            if (i.intValue() % 2 == 0)
                sum += i.intValue();
        return sum;
    }



    public static void unboxing() {
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // Π is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }




}





