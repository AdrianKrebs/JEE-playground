package ch.adriankrebs.services.book.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by Adrian on 5/21/2016.
 */
public class ClassDesign {

    //    Polymorphism deals with how the program decides which methods it should use,
    //Inheritance is when a 'class' derives from an existing 'class'.

    protected int testaccessor = 0;

    static class Super {

        public static void parseMeSuper() {

        }
    }

    static class Sub extends Super {

        static int MAX;
        static final String CLASS_GUID;

        static {
            MAX = 111;
            CLASS_GUID = "XYZ123";
        }

        public static void parseMeSub() {

        }
    }

    static int x = 5;

    public static void main(String[] args) {
        int x = (x = 3) * 4;  // 1
        System.out.println(x);


        String conjunction = "1";

        conjunction = conjunction + 1;

        A a = new A();
        B b = new B();
        a = b;  // 1
        b = (B) a;  // 2
        a = (B) b; // 3
        b = (B) a; // 4
        //For example, a Dog  "IS A" Animal, so you don't need to cast it.
        // But an Animal may not always be a Dog. So you need to cast it to make it compile and during the runtime the actual object referenced by animal should be a Dog
        // otherwise it will throw a ClassCastException.


      /*  Casting a base class to a subclass as in : b = (B) a; is also called as narrowing (as you are trying to narrow the base class object to a more specific class object) and needs explicit cast.
        Casting a sub class to a base class as in: A a = b; is also called as widening and does not need any casting.

                For example, consider two classes: Automobile and Car, where Car extends Automobile
        Now, Automobile a = new Car(); is valid because a car is definitely an Automobile. So it does not need an explicit cast.

        But, Car c = a; is not valid because 'a' is an Automobile and it may be a Car, a Truck, or a MotorCycle, so the programmer has to explicitly let the compiler know that at runtime 'a' will point to an object of class Car. Therefore, the programmer must use an explicit cast:
        Car c = (Car) a;
        */


        Super test1, test231;
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


        // compiler trusts you that s1 contains a sub object. if not classcastexception. -> therefore use always instance of check
        ((Sub) s1).parseMeSub();


        //----------------------------


        C c = new C();
        c.exceptionTest(); // no catch needed

        B b12 = new C();
        // b12.exceptionTest(); throws or catch needed because exceptions depend on class not object

        System.out.println(((A) c).i); //2 <--- cast it to A and u can actually access this variable beacause in A its public. for C its hidden
        //System.out.println(c.j); //3
        System.out.println(c.k);


        Z a2 = null;
        ZZ aa = null;

        aa = (ZZ) a2;


//        aa = (AA) a;
//        a is declared as a reference of class A and therefore, at run time, it is possible for a to point to an object of class AA (because A is a super class of AA).
//        Hence, the compiler will not complain. Although if a does not point to an object of class AA at run time, a ClassCastException will be thrown.
//        aa = a;
//        A cast is required because the compiler needs to be assured that at run time a will point to an object of class AA.
//        ((AA)a).doStuff();
//        Once you cast a to AA, you can call methods defined in AA. Of course, if a does not point to an object of class AA at runtime, a ClassCastException will be thrown.
//        In this particular case, a NullPointerException will be thrown because a points to null and a null can be cast to any class.


        InstanceofDemo.test();


        /// SHADOWING __________________________ OVERRIDING


        Car car = new SportsCar();
        System.out.println(car.gearRatio + "  " + car.accelerate());

        //Remember : variables are SHADOWED and methods are OVERRIDDEN.
//        Which variable will be used depends on the class that the variable is declared of.
//        Which method will be used depends on the actual class of
//        the object that is referenced by the variable.

        E o1 = new G();
        F o2 = (F) o1;
        System.out.println(o1.m1());
        System.out.println(o2.i);

        E test12 = new F();
        System.out.println(test12.i);
    }

    static class E {
        private int i = 10;


        int m1() {
            return i;
        }
    }

    static class F extends E {
        public int i = 20;

//    static method cannot be overridden by a non-static method and vice versa

//    void testStatic() {
//    }

        int m1() {
            return i;
        }
    }

    static class G extends F {
        int i = 30;

        int m1() {
            return i;
        }
    }


    static class Car {
        public int gearRatio = 8;

        public String accelerate() {
            return "Accelerate : Car";
        }
    }

    static class SportsCar extends Car {
        public int gearRatio = 9;

        public String accelerate() {
            return "Accelerate : SportsCar";
        }

        public void test() {

        }
    }

    class Z {
        public int getCode() {
            return 2;
        }
    }

    class ZZ extends Z {
        public void doStuff() {
        }
    }


    //extend multiple interfaces from each other
    interface T1 {
        int VALUE = 10;

        //        An interface can have a static method but the method must have a body
        static void testStatic() {

        }
        //An interface can redeclare a default method and provide a different implementation.

        default void test() {

        }

        void m1();

    }

    abstract interface T123 {
        // Interfaces are always abstract. They define the interface of a class,
        // so they are only about public methods, regardless the language, I think.
        public abstract void abstractInterface();

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

    class T4 implements T1, T2, T123 {

        T4() {
            // System.out.println(VALUE); not allowed since ambiguous
        }

        // Having ambiguous fields or methods does not cause any
        // problems by itself but referring to such fields/methods in an
        // ambiguous way will cause a compile time error. So you cannot call :
        // System.out.println(VALUE); because it will be ambiguous
        // (there are two VALUE definitions).


        //        tc.m1() is also fine because even though m1()
        // is declared in both the interfaces, the definition to both resolves
        // unambiguously to only one m1(), which is defined in TestClass.
        @Override
        // An overriding method can be made less restrictive than the overridden method

        public void m1() {
            System.out.println(T1.VALUE);
        }


        private void exceptionNotInTryBlock() {
            try {
                m1();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("1");
                throw new NullPointerException();// not catched!!!!
            } catch (NullPointerException e) {
                System.out.println("2");
                return;
            } catch (Exception e) {
                System.out.println("3");
            } finally {
                System.out.println("4");
            }
            System.out.println("END");
        }

        @Override
        public void abstractInterface() {

        }
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
        String courseName;

        void test() throws IOException {

        }

        public A() {
            this.courseName = "ORACLE";
        }
    }

    static abstract class AB extends A {

        @Override
        abstract void test();

    }


    static class B extends A {
        private int i = 30; //1
        public int k = 40;

        private void setShadow(int i) {
            // This outer variable is said to be shadowed by the inner variable
            this.i = i;
        }

        @Override
        public void test() throws FileNotFoundException{

        }

        public void exceptionTest() throws IOException, MyException {

        }

    }

    static class X extends AB {
        B getB() {
            return new B();
        }

        @Override
        void test() {

        }
    }

    static class Y extends X {

        //Covariant returns are allowed in Java 1.5, which means that an overriding method can change the return type of the overridden method to a subclass of the original return type.
        // Here, C is a subclass of B. So this is valid.
        @Override
        C getB() {
            return new C();
        }

    }


    static class C extends B {
        // overriden method can throw subclasses of exception thrown in parent
//  You are looking at the declarationAndComparing of the method in the class of the reference (not of actual object) to
// determine whether you have to put the call in try/catch or not (Or declare the throws clause of the caller appropriately).
        @Override
        public void exceptionTest() {

        }

    }


    private class MyException extends Exception {
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

     To override a method in the subclass, the overriding method (i.e. the one in the subclass) MUST HAVE:
    .same name
    .same return type in case of primitives (a subclass is allowed for classes, this is also known as covariant return types).
    .same type and order of parameters
    .it may throw only those exceptions that are declared in the throws clause of the superclass's method or exceptions that are subclasses of the declared exceptions. It may also choose NOT to throw any exception.
    The names of the parameter types do not matter. For example, void methodX(int i) is same as void methodX(int k)

     */


    static class OverrideParent {

        Object overrideTestMethod(int size) throws IOException {

            return "lol java certification sucks :)";
        }
    }

    static class OverrideChild extends OverrideParent {

        // you did that in the migration project to prevent migration data from validation. So you override the validate method with a new one which has a empty body
        @Override
        protected String overrideTestMethod(int size) throws FileNotFoundException, FileAlreadyExistsException {
            return "i just overide the parent method, i have the same arguments but a different implementation --> used in interfaces e.g";
        }
    }


    private static class TestPassingNull {
        public void method(Object o) {
            System.out.println("Object Version");
        }

        public void method(java.io.FileNotFoundException s) {
            System.out.println("java.io.FileNotFoundException Version");
        }

        public void method(java.io.IOException s) {
            System.out.println("IOException Version");
        }

        public static void main(String args[]) {
            TestPassingNull tc = new TestPassingNull();
            tc.method(null);
        }
    }

    /*
    The reason is quite simple, the most specific method depending upon the argument is called. Here, null can be passed to all the 3 methods but FileNotFoundException class is the subclass of IOException which in turn is the subclass of Object. So, FileNotFoundException class is the most specific class. So, this method is called.
Had there been two most specific methods, it would not even compile as the compiler will not be able to determine which method to call. For example:

public class TestClass{
   public void method(Object o){
      System.out.println("Object Version");
   }
   public void method(String s){
      System.out.println("String Version");
   }
   public void method(StringBuffer s){
      System.out.println("StringBuffer Version");
   }
   public static void main(String args[]){
      TestClass tc = new TestClass();
      tc.method(null);
   }
}


Here, null can be passed as both StringBuffer and String and none is more specific than the other. So, it will not compile.



     */

    static class Overload {

        // ONLY PARAMETERS MATTER!!!


//        There is no restriction on the return type. If the parameters are different then the methods are totally different (other than the name) so their return types can be anything.

//        Overloading of a method occurs when the name of more than one methods is exactly same but the parameter lists are different.

        //       Overloading also works when u just change the order of the arguments --> the JVM treats them as different method implementations
        private String overloadTestMethod(int size, int max) {
            return "lol java certification sucks :)";
        }

        private String overloadTestMethod(Integer size, Integer max) {
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

        void perform_work(int time) {
        }

        int perform_work(int time, int speed) {
            return time * speed;
        }
    }


    static class InstanceofDemo {
        public static void test() {

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


            Parent obj3 = new Parent();


            MyOtherInterface i = (MyOtherInterface) obj2;

            // assuming obj1 is a parent object

            //obj3 = (Child)i;

            obj3 = (Child) (MyOtherInterface) obj2;


        }
    }

    interface MyOtherInterface {
        // variables in interfaces are always public static final
        // methods are always public
        int test = 0;

    }

    static class Parent implements MyOtherInterface {
        int i;

        public static void main(String[] args) {
            Parent p = new Parent();

            //this.i; // no this operator
            int i = p.test;

            // works because its in same class as the Interface is implemented
            i = test;

        }

    }

    static class Child extends Parent implements MyInterface {


        public void setI(int y) {
            i = 22;
        }

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

    public void switchTest(byte x) {
        switch (x) {
            case 'b':   // 1
            default:   // 2
            case -2:    // 3
            case 80:    // 4
        }

    }
}

interface Account {
    public default String getId() {
        return "0000";
    }
}

interface PremiumAccount extends Account {
    public String getId();
}

abstract class BankAccount implements PremiumAccount {
    //    Since interface PremiumAccount redeclares getId method as abstract, the BankAccount class must either provide an implementation
// for this method or be marked as abstract.
//    In this case, making the class abstract will not help because of the statement - Account acct = new BankAccount();
//    public static void main(String[] args) {
//        Account acct = new BankAccount();
//        System.out.println(acct.getId());
//    }

    public int getId(int i) {
        return 1;
    }
}


interface A4 {
    public static final int testset = 5;

    default void hello() {
    }


    default void check() {

    }
}

interface B4 extends A4 {
    default void hello() {
        // super.hello();    //This is NOT valid.
        A4.super.hello();    //This is valid.
    }

    // void check();

     void blabla() throws FileNotFoundException;
}

abstract class B52 {

    abstract void testesttest();

    public void teslatws() {

        int[] test = new int[3];
        int[] overflow = {1, 2, 3, 4, 5};

        test = overflow;
        for (int i : test) {
            System.out.println(i);
        }

    }
}

class TestClass4 extends B52 implements B4 {

    public void hello() {
        // super.hello();//This is NOT valid.
        // A4.super.hello(); //This is NOT valid because TestClass does not implement A directly.
        B4.super.hello(); //This is valid.

    }

    private String hideTester() {
        return "hidden superclass method";
    }


    @Override
    public void blabla() throws FileNotFoundException{

    }

    @Override
    void testesttest() {

    }

    public static void main(String[] args) {
        TestClass4 t = new TestClass5();
        t.teslatws();
        System.out.println("test 1   hidden from within class : " + t.hideTester());
    }
}

class TestClass5 extends TestClass4 {

    public void blabla() {
        System.out.println("bla");
    }

    public String hideTester() {
        return "subclass method";
    }


}

class TestClass223 {
    public static void main(String[] args) {
        calculate(2);

        TestClass4 t = new TestClass5();
        // System.out.println("test 1   hidden from within class : " + t.hideTester()); -_> NOT COMPILE


    }

    public static void calculate(int x) {
        if (true)
            if (false)
                System.out.println("True False");
            else
                System.out.println("True True");

    }
}

class TestClass123 {

    public static void doStuff() throws Exception {
        System.out.println("Doing stuff...");
        if (Math.random() > 0.4) {
            throw new Exception("Too high!");
        }
        System.out.println("Done stuff.");
    }

    public static void main(String[] args) throws Exception {
        doStuff();
        System.out.println("Over");
    }
}

class Automobile {
}


class Car extends Automobile {

    public static void main(String[] args) {

        Automobile auto = new Car();
        Car car = new Car();
//        Once the object has been assigned a new reference type, only the methods and variables
//        available to that reference type are callable on the object without an explicit cast.

        /*
        Now, the rule is that if you have a container that is known to contain A, then the elements that you take out from it are only known to be of type A. For example, if you have an ArrayList of Cars (ArrayList<Car>) and if you take out an element from it, you know for sure that it will be a Car. It could be also be an SUV but you are not sure about that.
        Therefore, you cannot assign that element to a variable of type SUV without a cast.
        But since a Car is-a Vehicle, you can assign that element to a variable of type Vehicle.



         */

        car = (Car) (Automobile) car;

        //  This won't compile. By casting b1 to B, you are
        // telling the compiler that b1 points to an object
        // of class B. But you are then trying to assign this reference to b1, which is of class B1.
        // Compiler will complain against this assignment because there is no guarantee that an object of class B will also be of class B1.
        // To be able to assign an object of class B to a reference of class B1, you need to confirm to the compiler that the reference will actually point to an object of class B1.
        // Therefore, another cast is needed. i.e. b1 = (B1) (B) b1;


        auto = car;
        car = (Car) auto;

    }
}

// package privat --> default
class InitializationTest {
    static String staticString = "im gonna be initialized first -> static statements/blocks are first";
    String nullTester;
    static String initializerString;
// private class only allowed as inner classes


    public InitializationTest() {
        System.out.println("hi all I'm the last one");
    }


    static void initTest() {
        System.out.println(staticString);
    }

    {
        System.out.println(nullTester = "second, instance blocks/statements are initialized  ");
    }

    static {
        initTest();
        System.out.println(initializerString = "second one");

    }

    public static void main(String[] args) {
        new InitializationTest();
    }
}


  /*  For example, consider two classes: Automobile and Car, where Car extends Automobile
        Now, Automobile a = new Car(); is valid because a car is definitely an Automobile. So it does not need an explicit cast.

        But, Car c = a; is not valid because 'a' is an Automobile and it may be a Car, a Truck, or a MotorCycle, so the programmer has to explicitly let the compiler know that at runtime 'a' will point to an object of class Car. Therefore, the programmer must use an explicit cast:
        Car c = (Car) a;
        */