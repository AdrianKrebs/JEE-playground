package ch.adriankrebs.services.book.util;

/**
 * Created by U116523 on 09.06.2016.
 */
public class ExceptionHandling {

/*
The order in which the catch blocks are placed matters. If the caught exceptions have an inheritance relationship, the base class exceptions can’t be caught
before the derived class exceptions. An attempt to do this will result in compilation failure.
 */


    /* ----------------------ERRORS------------------------------

    ■  An error is a serious exception, thrown by the JVM as a result of an error in the
        environment state, which processes your code. For example, NoClassDefFoundError is an error thrown by the JVM when it is unable to locate the .class file it is
        supposed to run.

    ■   StackOverflowError is another error, thrown by the JVM when the size of the
        memory required by the stack of the Java program is greater than what the JRE
        has offered for the Java application. This error usually occurs as a result of infinite or highly nested loops.

    ■   Though you can handle the errors syntactically, there is little that you can do
        when these errors occur. For example, when the JVM throws OutOfMemoryError, your code execution will halt, even if you define an exception handler
        for it.



     */


    static String s = "";

    public static void m0(int a, int b) {
        s += a;
        m2();
        m1(b);
    }

    public static void m1(int i) {
        s += i;
    }

    public static void m2() {
        //    Now, m2() throws an exception which is not caught by m2() so it is propagated back to m0(1, 2).
        // Since, within m0 method, the call to m2() is not wrapped in a try catch block, this exception further propagates up to m(). ( The next line in m0(1, 2), which is m1(2), is not executed ).

        // because NullPointerException is an unchecked Exception we do not need to throw it up manually ---> check it
        throw new NullPointerException("aa");
    }

    public static void m() {
        m0(1, 2);
        m1(3);
    }

    public static void main(String args[])  {

        /*int amount = 100, seed = 6;
        switch( luckyNumber(6) ){
            case 3: amount = amount * 2;
            case 7: amount = amount * 2;
            case 6: amount = amount + amount;
            default :
        }
        System.out.println(amount);

        testMethod();*/

        try {
            RuntimeException tr = null;
            // logical -> null pointer is thown as soon as thows clause is called
            throw tr;
        }
        catch (Exception e){
            System.out.println(e);

        }

//        try {
//            m();
//        } finally {
//
//        }
//        System.out.println(s);
    }

    private static void testMethod() throws Exception{
        try{
            amethod();
            System.out.println("try ");
        }
        catch(Exception e){
            System.out.print("catch ");
        }
        finally   {
            System.out.print("finally ");
        }
        System.out.print("out ");
    }
    public static void amethod(){ throw new NullPointerException();}




    //
//    When you pass 6 to luckyNumber(), if(seed%2 == 0) throw new Exception("No Even no."); is executed and the exception is caught by the catch block where it tries to return 3; But as there is a finally associated with the try/catch block, it is executed before anything is returned. Now, as finally has return 7;, this value supersedes 3.
//    In fact, this method will always return 7 if seed <= 10.
//
//    Now, in the switch there is no break statement. So both -
//            case 7: amount = amount * 2;
//    and
//    case 6: amount = amount + amount;
//    are executed. so the final amount becomes 400.

    public static int luckyNumber(int seed){
        if(seed > 10) return seed%10;
        int x = 0;
        try{
            if(seed%2 == 0) throw new Exception("No Even no.");
            else return x;
        }
        catch(Exception e){
            return 3;
        }
        finally{
            return 7;
        }
    }


}


