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

            //evaluates expression after incrementing
            //therefore this statement is excuted 10  times like we expect it
            System.out.println("counting up with i++" + i);
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
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }



    public static void main(String[] args) {

        // twoWaysToIncrement();

        loopStatements();

    }

}
