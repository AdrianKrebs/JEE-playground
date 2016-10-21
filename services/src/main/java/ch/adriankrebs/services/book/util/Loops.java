package ch.adriankrebs.services.book.util;

/**
 * Created by U116523 on 18.04.2016.
 */
public class Loops {

    public static void twoWaysToIncrement() {
        int i = 0;

        while (++i < 10) {

            //++i increments the number before the current expression is evaluted
            // therefore this statement is excuted only 9 times
            System.out.println("counting up with ++i" + i);
        }

        i = 0;

        while (i++ < 10) {
            tEST: System.out.println("test");
            //evaluates expression after incrementing
            //therefore this statement is excuted 10  times like we expect it
            System.out.println("counting up with i++" + i);
            if (true) {


            }

        }

        int i2=0, j=11;
        do{
            if(i2 > j) { break; }
            j--;
        }while( ++i2 < 5);
        System.out.println(i2+"  "+j);

//        --k>0 implies, decrement the value of k and then compare with 0. Therefore, the loop will only  execute twice, printing 2 and 1.
//
//        Had it been k-->0, it would imply, first compare k with 0, and then decrement k. In this case, the loop would execute thrice, printing 2, 1, and 0.

        int k = 2;
        do{
            System.out.println(k);
        }while(--k>0);

        int k2 = 2;
        do{
            System.out.println(k2);
        }while(k2-->0);


        // both the same
        i = 0;
        for (; i < 5; i++) {
            System.out.println("counting up with i++" + i);
        }

        i = 0;

        for (; i < 5; ++i) {
            System.out.println("counting up with ++i" + i);
        }

    }

    public static void loopStatements() {


        String[] programmers = {"Paul", "Shreya", "Selvan", "Harry"};

        // continue statement
        //shreya is not printed out
        for (String name : programmers) {
            /*The continue statement is used to skip the remaining steps in the current iteration
            and start with the next loop iteration*/
            if (name.equals("Shreya"))
                continue;
            System.out.println(name);
        }

        // labeled statements

        System.out.println("testing labeled statement -> output: Paul,Shreya");
        outer: for (String outer : programmers) {
            for (String inner : programmers) {
                System.out.print(inner + ":");
                if (inner.equals("Shreya")) {
                    // without keyword breaks only breaks innermost outer loop!!
                    break outer;
                }
            }
        }

//        The initialization expression initializes the loop; it's executed once, as the loop begins.
//        When the termination expression evaluates to false, the loop terminates.
//        The increment expression is invoked after each iteration through the loop; it is perfectly acceptable for this expression to increment or decrement a value.
        for (int i = 0; i < 11; ++i) {

            System.out.println(i);

        }

    }

    private static void switchTest() {

//        ere are the rules for a switch statement:
//        1. Only String, byte, char, short, int, (and their wrapper classes Byte, Character, Short, and Integer), and enums can be used as types of a switch variable. (String is allowed only since Java 7).
//        2. The case constants must be assignable to the switch variable. For example, if your switch variable is of class String, your case labels must use Strings as well.
//        3. The switch variable must be big enough to hold all the case constants. For example, if the switch variable is of type char, then none of the case constants can be greater than 65535 because a char's range is from 0 to 65535.
//        4.  All case labels should be COMPILE TIME CONSTANTS.
//        5. No two of the case constant expressions associated with a switch statement may have the same value.
//        6. At most one default label may be associated with the same switch statement.

        short m = 5;
        switch (m) {


        }



        boolean b = false;
        int i = 1;
        do{
            i++ ;
        } while (b = !b);
        System.out.println( i );

        Float f = null;
        f = Float.valueOf("12.3");
        String s = f.toString();
        int i2 = Integer.parseInt(s);
        System.out.println("i = "+i2);

    }

    public static void switchTest(byte x){
        switch(x){
//            System.out.println("test");
        }

    }

    private static void testLoop() {

//        int[] arr = { 1, 2, 3, 4, 5, 6 };
//        int counter = 0;
//        for (int value : arr) {
//            if (counter >= 5) {
//                break;
//            } else {
//                continue;
//            }
//            if (value > 4) {
//                arr[counter] = value + 1;
//            }
//            counter++;
//        }
//        System.out.println(arr[counter]);



        // counter variable must be initialized

        // both allowed

        int i=10;
        for ( ; i>0 ; i--) { }

      //  for (int i=0, j=10; i<j; i++, --j) {;}

        for ( i=0 ;       ; i++) break;

        for (    ; i<5?false:true ;    );

//        The code will compile without error and will terminate
// without problems when run.

    }


    private static void breakDemo() {

        int[] arrayOfInts =
                { 32, 87, 3, 589,
                        12, 1076, 2000,
                        8, 622, 127 };
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }

    }


    private static void continueDemo() {

        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        int i = 10;

        System.out.println(i);
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }

    private static void weirdoLoopConstructs() {

        do { break ; } while (true) ;
        switch (1) { default : break; }
        for ( ; true ; ) break ;

        // break outside switch or loop is NOT allowed
       // if (true) { break ; }

        // but this is

        boolean b = false;
        int i = 1;
        do{
            i++ ;
        } while (b = !b);
        System.out.println( i );

        
        label: if(true){
            System.out.println("break label");
            break label; //this is valid
        }


        for (;;) {
            System.out.println("while tur");
        }


    }



    static boolean b;
    static int[] ia = new int[1];
    static char ch;
    static boolean[] ba = new boolean[1];

    public static void main(String[] args) {

        twoWaysToIncrement();
        breakDemo();

        //loopStatements();
        test:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j > 10) break test;
            }
            System.out.println("hello");
        }

        byte b2 = -2;
        switchTest(b2);

        boolean x = false;
        if( b ){
            x = ( ch == ia[ch]);
        }
        else x = ( ba[ch] = b );
        System.out.println(x+" "+ba[ch]);

        char i;
        LOOP:
        for (i = 0; i < 5; i++) {
            switch (i++) {
                case '0':
                    System.out.println("A");
                case 1:
                    System.out.println("B");
                    break LOOP;
                case 2:
                    System.out.println("C");
                    break;
                case 3:
                    System.out.println("D");
                    break;
                case 4:
                    System.out.println("E");
                case 'E':
                    System.out.println("F");
                default:
                    System.out.println(i);
            }
        }
    }


}




