package services.book.util;

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

    }

    public static void main(String[] args) {

        // twoWaysToIncrement();

        loopStatements();

    }

}
