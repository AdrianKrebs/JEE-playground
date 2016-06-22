package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 5/21/2016.
 */
public class Polymorphism {


    static class Super {

        public static void parseMeSuper() {

        }
    }

    static class Sub extends Super {

        public static void parseMeSub() {

        }
    }

    public static void main(String[] args) {


        //For example, a Dog  "IS A" Animal, so you don't need to cast it.
        // But an Animal may not always be a Dog. So you need to cast it to make it compile and during the runtime the actual object referenced by animal should be a Dog
        // otherwise it will throw a ClassCastException.


        Super s1 = new Super(); //1
        Sub s2 = new Sub();
        // works

        // i can either assign a sub to its superclass
        // or cast the sub to the superclass
      //  s1 = s2;
        s2.parseMeSub();
        s2.parseMeSuper();
        s1.parseMeSuper();
        //s1 = (Super)s2;        //3
        s1.parseMeSuper();

        //throws classcastexception
        s1 = new Sub();
       // s2 = (Sub) s1;

        ((Sub)s1).parseMeSub();


        //----------------------------


        C c = new C();
        System.out.println(((A) c).i); //2 <--- cast it to A and u can actually access this variable beacause in A its public. for C its hidden
        //System.out.println(c.j); //3
        System.out.println(c.k);




        Z a = null;
        ZZ aa = null;

        aa = (ZZ) a;


//        aa = (AA) a;
//        a is declared as a reference of class A and therefore, at run time, it is possible for a to point to an object of class AA (because A is a super class of AA).
//        Hence, the compiler will not complain. Although if a does not point to an object of class AA at run time, a ClassCastException will be thrown.
//        aa = a;
//        A cast is required because the compiler needs to be assured that at run time a will point to an object of class AA.
//        ((AA)a).doStuff();
//        Once you cast a to AA, you can call methods defined in AA. Of course, if a does not point to an object of class AA at runtime, a ClassCastException will be thrown.
//        In this particular case, a NullPointerException will be thrown because a points to null and a null can be cast to any class.


    }

    class Z {
        public int getCode(){ return 2;}
    }

    class ZZ extends Z {
        public void doStuff() {
        }
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

        // ONLY PARAMETERS MATTER!!!


//        There is no restriction on the return type. If the parameters are different then the methods are totally different (other than the name) so their return types can be anything.

//        Overloading of a method occurs when the name of more than one methods is exactly same but the parameter lists are different.

//       Overloading also works when u just change the order of the arguments --> the JVM treats them as different method implementations
        private String overloadTestMethod(int size, int max) {
            return "lol java certification sucks :)";
        }

        private String overloadTestMethod(int size, String max) {
            return "overloaded!!!!";
        }

        private String overloadTestMethod(int size) {
            return "lol java certification sucks :)";
        }

        private int overloadTestMethod(int size, int test2, int test_2) {
            return 5;
        }

        void perform_work(int time){ }
        int  perform_work(int time, int speed){ return time*speed ;}
    }


    class InstanceofDemo {
        public void test() {

            Parent obj1 = new Parent();
            Parent obj2 = new Child();

            System.out.println("obj1 instanceof Parent: "
                    + (obj1 instanceof Parent));
            System.out.println("obj1 instanceof Child: "
                    + (obj1 instanceof Child));
            System.out.println("obj1 instanceof MyInterface: "
                    + (obj1 instanceof MyInterface));
            System.out.println("obj2 instanceof Parent: "
                    + (obj2 instanceof Parent));
            System.out.println("obj2 instanceof Child: "
                    + (obj2 instanceof Child));
            System.out.println("obj2 instanceof MyInterface: "
                    + (obj2 instanceof MyInterface));
        }
    }

    class Parent {
    }

    class Child extends Parent implements MyInterface {
    }

    interface MyInterface {
    }


    static class StaticNestedClass {

    }

    class InnerClass {

    }

//    btn.setOnAction(new EventHandler<ActionEvent>() {
//
//        @Override
//        public void handle(ActionEvent event) {
//            System.out.println("Hello World!");
//        }
//    });

    private static void garbageCollection() {
        String studentName = "Peter Smith";
        String[] students = new String[10];
        students[0] = studentName;
        studentName = null;

        //Answer: There is one reference to the students array and that array has one reference to the string Peter Smith.
        // Neither object is eligible for garbage collection.
        // The array students is not eligible for garbage collection because it has one reference to the object studentName even though that object has been assigned the value null.
        // The object studentName is not eligible either because students[0] still refers to it.


    }


}
