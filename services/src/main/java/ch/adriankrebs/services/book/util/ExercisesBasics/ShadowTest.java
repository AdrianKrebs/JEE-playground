package ch.adriankrebs.services.book.util.ExercisesBasics;

import java.util.ArrayList;
import java.util.List;

public class ShadowTest {


    // VARIABLE SHADOWING _________________________________

    public int x = 0;

    class FirstLevel {

        private int x = 1;

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


class A{
    private int i = 10;
    public void  f(){}
    public void g(){}
}

class B extends A{
    public int i = 20;
    public void g(){}
}

 class C{

     C() {
         A a = new A();//1
         B b = new B();//2
         A a2 = new B();

         a2.f();
        b.i = 10;

         // remember __> method ---> object ---> VARIABLE --> CLASS --> i not accessable in A
     }
}

class A2{
    final int fi = 10;
}
class B2 extends A2{
    public void test() {

    }
    int fi = 15;
    public static void main(String[] args){
        B2 b = new B2();

        b.fi = 20;
        System.out.println(b.fi);
        new B2().test();
        System.out.println(  (  (A2) b  ).fi  );
    }
}

 class TestClass{
    public static void main(String[] args){  new TestClass().sayHello(); }   //1
  //  public static void sayHello(){ System.out.println("Static Hello World"); }  //2
   public void sayHello() { System.out.println("Hello World "); }  //3
}

class A3{
    public A3() {} // A1
    public A3(String s) {  this();  System.out.println("A :"+s);  }  // A2
}

class B3 extends A3{
    ArrayList test;
    public static void main(String[] args) {

        System.out.println(getMsg((char)10));
        List al = new ArrayList(); //1
        al.add(111); //2
        System.out.println(al.get(al.size()));  //3

    }

    public static String getMsg(char x){
        System.out.println("char is "+x);
        String msg = "Input value must be ";
       msg = msg.concat("smaller than X");
        msg.replace('X', x);
        String rest = " and larger than 0";
        msg.concat(rest);
        return msg;
    }
    public int B3(String s) {  System.out.println("B :"+s);  return 0; } // B1
}
class C3 extends B3{
    private C3(){ super(); } // C1
    public C3(String s){  this();  System.out.println("C :"+s);  } // C2
    public C3(int i){} // C3


}



