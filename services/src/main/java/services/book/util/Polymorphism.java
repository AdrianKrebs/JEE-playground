package services.book.util;

/**
 * Created by Adrian on 5/21/2016.
 */
public class Polymorphism {


    // Bad Syntax. Syntax for importing static fields is:
    //  import static <package>.<classname>.*; or import static <package>.<classname>.<fieldname>;


    static class Super {
    }

    static class Sub extends Super {
    }

    public static void main(String[] args) {


        //For example, a Dog  "IS A" Animal, so you don't need to cast it.
        // But an Animal may not always be a Dog. So you need to cast it to make it compile and during the runtime the actual object referenced by animal should be a Dog
        // otherwise it will throw a ClassCastException.


        Super s1 = new Super(); //1
        Sub s2 = new Sub();
        // works
        s1 = (Super) s2;        //3

        //throws classcastexception
        s2 = (Sub) s1;

        //----------------------------


        C c = new C();
        System.out.println(((A) c).i); //2 <--- cast it to A and u can actually access this variable beacause in A its public. for C its hidden
        //System.out.println(c.j); //3
        System.out.println(c.k);


    }


    //extend multiple interfaces from each other
    interface T1 {
    }

    interface T2 {
        int VALUE = 10;

        //Any field in an interface is implicitly public, static, and final, whether these keywords are specified or not.
        void m1();
    }

    interface T3 extends T1, T2 {
        public void m1();

        public void m1(int x);
    }



    /*variables in inherited Classes
      -----------------------------------
       You cannot access c.i because i is private in B.
       But you can access ( (A)c).i because i is public in A. Remember that member variables are hidden and not overridden.
       So, B's i hides A's i and since B's i is private, you can't access A's i unless you cast the reference to A.
       You cannot access c.j because j is private in     */

    static class A {
        public int i = 10;
        private int j = 20;


    }

    static class B extends A {
        private int i = 30; //1
        public int k = 40;

        private void setShadow(int i) {
            // This outer variable is said to be shadowed by the inner variable
            this.i = i;
        }

    }

    static class C extends B {
    }


    /* native keyword in Java
       --------------------------------------

     The native keyword is applied to a method to indicate that the method is implemented in native code using JNI(Java Native Interface).
     It marks a method, that it will be implemented in other languages, not in Java. It works together with JNI (Java Native Interface).
     */
    private native void testJNI(int size);




    /*
    Overloading and Overriding
    -----------------------------------------
    Method overloading deals with the notion of having two or more methods in the same class with the same name but different arguments.

    Method overriding means having two methods with the same arguments, but different implementations. One of them would exist in the parent class,
    while another will be in the derived, or child class. The @Override annotation, while not required, can be helpful to enforce proper overriding of a method at compile time.
     */


    static class OverrideParent {

        public String overrideTestMethod(int size) {

            return "lol java certification sucks :)";
        }
    }

    static class OverrideChild extends OverrideParent {

        // you did that in the migration project to prevent migration data from validation. So you override the validate method with a new one which has a empty body
        @Override
        public String overrideTestMethod(int size) {
            return "i just overide the parent method, i have the same arguments but a different implementation --> used in interfaces e.g";
        }
    }

    static class Overload {

        private String overloadTestMethod(int size, int max) {
            return "lol java certification sucks :)";
        }

        private String overloadTestMethod(int size, String max) {
            return "overloaded!!!!";
        }

        private String overloadTestMethod(int size) {
            return "lol java certification sucks :)";
        }
    }






}
