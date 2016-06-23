package ch.adriankrebs.services.book.util.ExercisesBasics;

public class ShadowTest {


    // VARIABLE SHADOWING _________________________________

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
        ATest ct = new ATest();
        System.out.print(ct.parse("333"));
    }


    //STATIC METHOD SHADOWING _________________________________

//    Another concept (although not related to this question but about static methods) is that static methods are never overridden. They are HIDDEN or SHADOWED just like static or non-static fields. For example,
//    class A{
//        int i = 10;
//        public static void m1(){  }
//        public void m2() { }
//    }
//    class B extends A{
//        int i = 20;
//        public static void m1() {  }
//        public void m2() { }
//    }
//    Here, UNLIKE m2, m1() of B does not override m1() of A, it just shadows it, as proven by the following code:
//    A a  = new B();
//    System.out.println(a.i)  //will print 10 instead of 20
//            a.m1();  //will call A's m1
//    a.m2();  //will call B's m2 as m2() is not static and so overrides A's m2()



}

class ATest {


    String global = "111";

    public int parse(String arg) {
        int value = 0;
        try {
            String global = arg;
            value = Integer.parseInt(global);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        System.out.print(global + " " + value + " ");
        return value;
    }

}

