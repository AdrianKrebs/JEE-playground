package ch.adriankrebs.services.book.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by U116523 on 19.04.2016.
 */
public class DataTypes {

//    byte -> 8 bit
//    a maximum value of 127 (inclusive) --> 1111 1111 -> FF -> 2^8 = 256. The byte data type can be useful for saving memory in large arrays, where the memory savings actually matters.
//    They can also be used in place of int where their limits help to clarify your code; the fact that a variable's range is limited can serve as a form of documentation.
//
//    boolean: boolean data type represents one bit of information.
//
//    byte: Byte data type is a 8-bit signed two's complement integer.
//
//    Short: Short data type is a 16-bit signed two's complement integer.
//    char: char data type is a single 16-bit Unicode character.
//
//
//    int: Int data type is a 32-bit signed two's complement integer.
//
//    long: Long data type is a 64-bit signed two's complement integer.
//
//    float: Float data type is a single-precision 32-bit IEEE 754 floating point.
//
//    double: double data type is a double-precision 64-bit IEEE 754 floating point.


    // ------ Difference primitives and reference variables----------
    //      The basic difference is that primitive
    //        variables store the actual values, whereas reference variables store the addresses of the
    //        objects they refer to.


//   (superclass)                                   Number
    //                                       __________/\__________
    //                                      /       |      |       \
//   (concrete subclasses)               Integer   Long    Float   Double


    private static void operators() {

//        All operands of type byte, char or short are promoted AT LEAST to an int before performing mathematical operations. If one of the operands is larger than an int then the other one is promoted to the same type.
//                Note that System.out.println((float)5/4); will print 1.25. If you remove the explicit cast (float), it will print 1.

        System.out.println(1 + 2 + "3");// would print 33.
//        operator + is left associative so evaluation of (1 + 2 + "3" ) is as follows: ( 1 + 2 ) + "3" -> 3 + "3" -> "33".
        System.out.println("1" + 2 + 3); // = 123


        System.out.println(5 / 4); // --> promoted to int so it results in 1 not 1.25 --> with cast it would work
        System.out.println((float) 5 / 4);

//        In the case of i == f, value of i will be promoted to a float i.e. 5.0, and so it returns false.

         float testComparing = 5.5f;
        int testComparing2 = 5;

        System.out.println(testComparing == testComparing2); // false

//        The statement iA[i] = i = 30 ; will be processed as follows:
//        iA[i] = i = 30; => iA[0] = i = 30 ;  =>  i = 30; iA[0] = i ; =>   iA[0] = 30 ;
//
//        Here is what JLS says on this:
//        1 Evaluate Left-Hand Operand First
//        2 Evaluate Operands before Operation
//        3 Evaluation Respects Parentheses and Precedence
//        4 Argument Lists are Evaluated Left-to-Right
//

        // prints out 14, 25
        //First, a's value of 10 is kept aside and (a=4) is evaluated
        int a = 10;
        int b = 20;
        a += (a = 4);
        b = b + (b = 5);
        System.out.println(a + ",  " + b);


//        For Arrays: First, the dimension expressions are evaluated, left-to-right. If any of the expression evaluations completes abruptly, the expressions to the right of it are not evaluated.
        int i = 0;
        int[] iA = {10, 20};
        iA[i] = i = 30;
        byte positve = 126;
        byte negatic = -128;
        System.out.println("" + iA[0] + " " + iA[1] + "  " + i);
    }

    public static void declarationAndComparing() {
        int k = 1;
        k += 3 + ++k;
        int k2 = 1;
        k2 = k2 + 3 + 2;
        int k3 = 1;


        k3 += 3 + (k3 =1) + k3 + 1;

        System.out.printf("should be 7 :"+k3);
        if (k2 == k) {
            System.out.println("equal");
        }
        System.out.println("value of k : "+k);

        // 6 --_> since 1 = 1 + 3 + 2
        // k is saved asside

        boolean bb = true || false;
        boolean db = true | false;
        Boolean b = new Boolean("yes"); // false
        boolean bbbb = Boolean.parseBoolean("true"); // -----> parse boolean returns int!

        /*
        You need to remember the following points about Boolean:

1. Boolean class has two constructors - Boolean(String) and Boolean(boolean)
The String constructor allocates a Boolean object representing the value true if the string argument is not null and is equal,
 ignoring case, to the string "true". Otherwise, allocate a Boolean object representing the value false. Examples: new Boolean("True")
  produces a Boolean object that represents true. new Boolean("yes") produces a Boolean object that represents false.

The boolean constructor is self explanatory.

2. Boolean class has two static helper methods for creating booleans - parseBoolean and valueOf.
Boolean.parseBoolean(String ) method returns a primitive boolean and not a Boolean object (Note - Same is with the case with other parseXXX methods such as Integer.parseInt - they return primitives and not objects). The boolean returned represents the value true if the string argument is not null and is equal, ignoring case, to the string "true".

Boolean.valueOf(String ) and its overloaded Boolean.valueOf(boolean ) version, on the other hand, work similarly but return a reference to either Boolean.TRUE or Boolean.FALSE wrapper objects. Observe that they dont create a new Boolean object but just return the static constants TRUE or FALSE defined in Boolean class.

3. When you use the equality operator ( == ) with booleans, if exactly one of the operands is a Boolean wrapper, it is first unboxed into a boolean primitive and then the two are compared (JLS 15.21.2). If both are Boolean wrappers, then their references are compared just like in the case of other objects.
Thus, new Boolean("true") == new Boolean("true") is false, but new Boolean("true") == Boolean.parseBoolean("true") is true.


         */

        long g = 012;

        float f = 320;
        char c = 310;

        int i1 = 1, i2 = 2, i3 = 3;
        long longliteral = 16l; // It is recommended that you use the upper case letter L because the lower case letter l is hard to distinguish from the digit 1.
        boolean b1, b2, b3, b4, b5, b6; // line 1
        b1 = b2 = b3 = true; // allowed because same type

        int explicitCast = (int) longliteral;

//        Note that Java can only accept wider types. An int can be passed to a method taking a
//        long parameter. Java will not automatically convert to a narrower type. If you want to pass
//        a long to a method taking an int parameter, you have to add a cast to explicitly say narrowing is okay.

        //  Chaining to use a value of a variable at the time of declarationAndComparing is not allowed. Had b and c been already declared, it would have been valid. For example, the following is valid:
        //int a = b = c = 100;

//        Min byte value   = -128
//        Max byte value   = 127
//        Min short value  = -32768
//        Max short value  = 32767
//        Min int value    = -2147483648
//        Max int value    = 2147483647
//        Min long value    = -9223372036854775808
//        Max long value    = 9223372036854775807
//        Min float value  = 1.4E-45
//        Max float value  = 3.4028235E38
//        Min double value = 4.9E-324
//        Max double value = 1.7976931348623157E308
        // float wayToBig = 34e4;
        int b23 = 0, cc = 0;
        int a = b23 = cc = 100;
        // Even the following is valid:
        int bbb, ccc;  //Not initializing b and c here.
        int aaa = bbb = ccc = 100; //declaring a and initializing c, b, and a at the same time.


        char test = 'a';
        final short lala = 12;

        //test = lala; // short has different length that char --> so adding final works --> you tell the compiler : I know what im doig


        /*

        So while they are both 2-byte long, they use the sixteenth bit for different purposes.

        The range of the char type is 0 to 2^16 - 1 (0 to 65535).

        The short range is -2^15 to 2^15 - 1 (−32,768 to 32,767).
         */
        for (int i = 0; i < 3; i++) {
            System.out.println(test++); // a, b, c
        }


        int octTest = 0XA;
        System.out.println(octTest);

        // comparing all primitves works



        byte b9 = 1;
        char c9 = 1;
        short s9 = 1;
        int i9 = 1;
        short x = 3;
        x += 4.6;


//        c9 = c9 + b9; --> returns int // ---> see point 3

        /*

        1. Anything bigger than an int can NEVER be assigned to an int or anything smaller than int ( byte, char, or short) without explicit cast.
        2. CONSTANT values up to int can be assigned (without cast) to variables of lesser size ( for example, short to byte) if the value is representable by the variable.( that is, if it fits into the size of the variable).
        3. operands of mathematical operators are ALWAYS promoted to AT LEAST int. (i.e. for byte * byte both bytes will be first promoted to int.) and the return value will be AT LEAST int.
        4. Compound assignment operators ( +=, *= etc)  have strange ways so read this carefully:

        A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T)((E1) op (E2)), where T is the type of E1, except that E1 is evaluated only once.
        Note that the implied cast to type T may be either an identity conversion or a narrowing primitive conversion.
        For example, the following code is correct:

        short x = 3;
        x += 4.6;

        and results in x having the value 7 because it is equivalent to:

        short x = 3;
        x = (short)(x + 4.6);
         */


    }


    public static void bitsAndBytes() {

        // prints binary
        System.out.println(Integer.toBinaryString(0b100001011));

        // prints decimal
        System.out.println(0b100001011);
        byte maxRange = 127;
        maxRange = 'c';

        // two complement example
        System.out.println("two complements " + Integer.toBinaryString(-2));

        // weil führende 1 ist negativ
        System.out.println(Short.valueOf("10000010", 2).byteValue());  // -1 (byte)

        short res = (short) Integer.parseInt("1111111111001110", 2);
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

        long test = 121;
        char testet = (char)test;
        long tewt= testet;

        byte byteliteral = 0b1111111; // = 127

        String sa[ ] = new String[ ]{"a", "b", "c"};

        int octaltest = 01;

        // java uses two complement -> negative numbers are stored internally by toggeling all bits and adding 1

    }


     static public void main(String[] args) {
        // Literals
        arrays();
        declarationAndComparing();
        unboxing();


//        Wrapper objects are always immutable.
        Integer a = 4; probe(a); //5
        int b = 4; probe(b); //6
        a = 2;

//         Equals method of a primitive wrapper class ( e.g. java.lang.Integer, Double, Float etc) are
//         1. symmetric => a.equals(b) returns same as b.equals(a)
//         2. transitive => if a.equals(b) and b.equals(c) return true, then a.equals(c) returns true.
//         3. reflexive => a.equals(a) return true.


    }

       static void probe(int... x) { System.out.println("In ..."); }  //1

       static void probe(Integer x) { System.out.println("In Integer"); } //2

      static   void probe(long x) { System.out.println("In long"); } //3

       static void probe(Long x) { System.out.println("In LONG"); } //4

/*

To answer this type of questions, you need to know the following rules:

1. The compiler always tries to choose the most specific method available with least number of modifications to the arguments.

2. Java designers have decided that old code should work exactly as it used to work before boxing-unboxing functionality became available.

3. Widening is preferred to boxing/unboxing (because of rule 2), which in turn, is preferred over var-args.


Thus,
1.
probe(Integer) will be bound to probe(Integer) (exact match). If that is not available, it will be bound to probe(long), and then with probe(int...) in that order of preference.
probe(long) is preferred over probe(int...) because unboxing an Integer gives an int and in pre 1.5 code probe(long) is compatible with an int (Rule 2).

It is never bound to probe(Long ) because Integer and Long are different object types and there is no IS-A relation between them. (This holds true for any two wrapper classes).
It could, however, be bound to probe(Object ) (if it existed), because Integer IS-A Object.

2.
probe(int) is bound to probe(long) (because of Rule 2) , then to probe(Integer ) because boxing an int qives you an Integer, which matches exactly to probe(Integer), and then to probe(int...).

It is never bound to probe(Long ) because int is not compatible with Long.

We advise you to run this program and try out various combinations. The exam has questions on this pattern but they are not this tough. If you have a basic understanding, you should be ok.


 */

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
        for (Integer i : li)
            if (i % 2 == 0)
                sum += i;
        return sum;
    }


    //Because the remainder (%) and unary plus (+=) operators do not apply to Integer objects, you may wonder why the Java compiler compiles the method without issuing any errors.
    // The compiler does not generate an error because it invokes the intValue method to convert an Integer to an int at runtime:

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


    private static void parserError() {
//        f = Float.valueOf("12.3"); executes without any problem.
//        int i = Integer.parseInt(s); throws a NumberFormatException because 12.3 is not an integer.
//        Thus, the catch block prints trouble : 12.3

        // difference valueOf, parseInt
        // parsing is always a String to --> int,float

//        However, valueOf(String) returns a new Integer() object whereas parseInt(String) returns a primitive int.
        // same with Booolean.valueOf --> Boolean --> Boolean.parseBoolean --> boolean


        Float f = null;
        try {
            f = Float.valueOf("12.3");
            String s = f.toString();
            int i = Integer.parseInt(s);
            System.out.println("i = " + i);
        } catch (Exception e) {
            System.out.println("trouble : " + f);
        }
    }


    private static void arrays() {

        //http://stackoverflow.com/documentation/java/99/arrays/404/creating-arrays#t=201607230908200850997


//        There is a subtle difference between: int[] i; and int i[]; although in both the cases, i is an array of integers.
//         The difference is if you declare multiple variables in the same statement such as: int[] i, j; and int i[], j;, j is not of the same type in the two cases.
//           In the first case, j is an array of integers while in the second case, j is just an integer.
        int[] array1, array2[];
        array1 = new int[2];
        array2 = new int[2][1];


        int i[ ][ ] = new int[ ][ ] { {1, 2, 3}, {4, 5, 6} } ;
        int i234[ ][ ] = new int[ ][ ] { {1, 2, 3}, {4, 5, 6} } ;

        int array10[], arrayOrInt;

        // preferred way is int [] testArray; --> with no side effect -> testArray,testArray2 will result in two arrays instead of array and int

        arrayOrInt = 5;


        int[] array6[] = new int[00][01];


        int[] array4[], array5[];
        array4 = array5 = new int[2][];


        int a[][] = new int[2][];
        a[0] = new int[2];
        a[1] = new int[4];
        // MULTIDIMENSIONAL

        // NOT ALLED . X has to be initialized Y is optional
//        int b[][]  = new int [][4];
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);

        System.out.println(names[1].getClass().isArray() + names[1][1]);

        // COPYING

        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));


        char[] copyFrom2 = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));


        Object obj[] = new Object[]{"aaa", new Object(), new ArrayList(), 10};

        int[][] nir = new int[2][3];

        // length of first dimension
        System.out.println(nir.length);
        // length of first dimension
        System.out.println(nir[1].length);

        String[] array = {"bbbb", "dddd", "aaaa", "cccc"};

        Arrays.sort(array, (str1, str2) -> {
            // some custom comparison of `str1` and `str2`
            return str1.length() - str2.length();
        });


        // valid
        String[][] employeeGraph = new String[30][];

        int[][] c;
        c = new int[2][]; // creates 2 rows
        c[0] = new int[5]; // 5 columns for row 0
        c[1] = new int[3]; // create 3 columns for row 1

// invalid
        //int[][] unshapenMatrix = new int[][10];


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





