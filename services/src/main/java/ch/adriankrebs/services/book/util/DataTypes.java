package ch.adriankrebs.services.book.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U116523 on 19.04.2016.
 */
public class DataTypes {

    //byte -> 8 bit
//    a maximum value of 127 (inclusive) --> 1111 1111 -> FF -> 2^8 = 256. The byte data type can be useful for saving memory in large arrays, where the memory savings actually matters.
//    They can also be used in place of int where their limits help to clarify your code; the fact that a variable's range is limited can serve as a form of documentation.

//    byte: Byte data type is a 8-bit signed two's complement integer.
//
//    Short: Short data type is a 16-bit signed two's complement integer.
//
//    int: Int data type is a 32-bit signed two's complement integer.
//
//    long: Long data type is a 64-bit signed two's complement integer.
//
//    float: Float data type is a single-precision 32-bit IEEE 754 floating point.
//
//    double: double data type is a double-precision 64-bit IEEE 754 floating point.
//
//    boolean: boolean data type represents one bit of information.
//
//    char: char data type is a single 16-bit Unicode character.


    private static void operators() {

//        All operands of type byte, char or short are promoted AT LEAST to an int before performing mathematical operations. If one of the operands is larger than an int then the other one is promoted to the same type.
//                Note that System.out.println((float)5/4); will print 1.25. If you remove the explicit cast (float), it will print 1.

        System.out.println(1 + 2 + "3");// would print 33.
//        operator + is left associative so evaluation of (1 + 2 + "3" ) is as follows: ( 1 + 2 ) + "3" -> 3 + "3" -> "33".
        System.out.println("1" + 2 + 3); // = 123


        System.out.println(5/4); // --> promoted to int so it results in 1 not 1.25 --> with cast it would work
        System.out.println((float)5/4); // --> promoted to int so it results in 1 not 1.25 --> with cast it would work


//        The statement iA[i] = i = 30 ; will be processed as follows:
//        iA[i] = i = 30; => iA[0] = i = 30 ;  =>  i = 30; iA[0] = i ; =>   iA[0] = 30 ;
//
//        Here is what JLS says on this:
//        1 Evaluate Left-Hand Operand First
//        2 Evaluate Operands before Operation
//        3 Evaluation Respects Parentheses and Precedence
//        4 Argument Lists are Evaluated Left-to-Right
//
//        For Arrays: First, the dimension expressions are evaluated, left-to-right. If any of the expression evaluations completes abruptly, the expressions to the right of it are not evaluated.

        int i = 0 ;
        int[] iA = {10, 20} ;
        iA[i] = i = 30 ;
        System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + "  "+i) ;


    }

    public static void main(String[] args) {


        boolean b = true||false;
        boolean d = true|false;

        long g = 012;

        float f = 320;
        char c = 310;
        // prints binary
        System.out.println(Integer.toBinaryString(0b100001011));

        // prints decimal
        System.out.println(0b100001011);
        byte maxRange = 127;
        maxRange = 'c';

        // Literals

        long longliteral = 16l; // It is recommended that you use the upper case letter L because the lower case letter l is hard to distinguish from the digit 1.
        byte byteliteral = 0b1111111; // = 127

        // java uses two complement -> negative numbers are stored internally by toggeling all bits and adding 1


        // two complement example
        System.out.println("two complements " + Integer.toBinaryString(-2));

        // weil führende 1 ist negativ
        System.out.println(Short.valueOf("10000010",2).byteValue());  // -1 (byte)

        short res = (short)Integer.parseInt("1111111111001110", 2);
        System.out.println(res);

//        The unary bitwise complement operator "~" inverts a bit pattern;

        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);


//        ~       Unary bitwise complement
//        <<      Signed left shift
//                >>      Signed right shift
//        >>>     Unsigned right shift
//                &       Bitwise AND
//                ^       Bitwise exclusive OR
//        |       Bitwise inclusive OR




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




        unboxing();

        int i = 0;
        String s = "";

        //s = null;
        if ((s != null) | ( i==s.length())) {}
        System.out.println("A");

        //s = null;
        if ((s == null) | ( i==s.length())) {}
        System.out.println("B");

        //s = null;
        if ((s != null) || (i==s.length())) {}
        System.out.println("C");

        s = null;
        if ((s == null) || (i==s.length())) {}
        System.out.println("D");


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


    private static void arrays() {

        // MULTIDIMENSIONAL

        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);

        // COPYING

        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));


        char[] copyFrom2 = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));


        // Other useful methods

//        Searching an array for a specific value to get the index at which it is placed (the binarySearch method).
//        Comparing two arrays to determine if they are equal or not (the equals method).
//                Filling an array to place a specific value at each index (the fill method).
//        Sorting an array into ascending order. This can be done either sequentially,
// using the sort method, or concurrently, using the parallelSort method introduced in Java SE 8.
// Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.


    }

    // SUMMARY

//    The Java programming language uses both "fields" and "variables" as part of its terminology.
// Instance variables (non-static fields) are unique to each instance of a class. Class variables (static fields) are fields declared with the static modifier;
// there is exactly one copy of a class variable, regardless of how many times the class has been instantiated. Local variables store temporary state inside a method.
// Parameters are variables that provide extra information to a method; both local variables and parameters are always classified as "variables" (not "fields").
// When naming your fields or variables, there are rules and conventions that you should (or must) follow.
//
//    The eight primitive data types are: byte, short, int, long, float, double, boolean, and char.
// The java.lang.String class represents character strings. The compiler will assign a reasonable default value for fields of the above types; for local variables,
// a default value is never assigned. A literal is the source code representation of a fixed value. An array is a container object that holds a fixed number of values of a single type.
// The length of an array is established when the array is created. After creation, its length is fixed.







}





