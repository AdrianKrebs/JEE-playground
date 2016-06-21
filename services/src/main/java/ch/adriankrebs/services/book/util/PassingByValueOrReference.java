package ch.adriankrebs.services.book.util;

import java.util.Stack;

/**
 * Created by U116523 on 06.04.2016.
 */
public class PassingByValueOrReference {

    // is not a Dog; it's actually a pointer to a Dog.
    //Java is always pass-by-value. Unfortunately, they decided to call pointers references, thus confusing newbies. Because those references are passed by value.
    // Discussion here http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value

    public static void main(String[] args) {
        {
            Dog aDog = new Dog("Max");
            foo(aDog);

            if (aDog.getName().equals("Max")) { //true
                System.out.println("Java passes by value.");

            } else if (aDog.getName().equals("Fifi")) {
                System.out.println("Java passes by reference.");
            }

        }
        Stack s1 = new Stack ();
        Stack s2 = new Stack ();
        processStacks (s1,s2);
        System.out.println (s1 + "    "+ s2);
    }
    public static void processStacks(Stack x1, Stack x2){
//        Step 2;
//        s1 -----> [ 100 ] STACK 1 OBJECT <----x1 Local variable
//        Because x1 is referring to the same memory location.
//                s2 -----> [ EMPTY ] STACK 2 OBJECT <---x2 Local variable
//
//        Step 3: After doing x2 = x1
//        s1 ---> [ 100 ] STACK 1 OBJECT <---- x1 and x2 Local variables
//        s1 and x1 both contain 15000 (say) and x2 now also contains 15000.
//        s2 ------------> [ EMPTY ] STACK 2 OBJECT
//
//        But s2 still contains 25000.


        x1.push (new Integer ("100")); //assume that the method push adds the passed object to the stack.
        x2 = x1;
    }
    // you cant set a new Dog to Max --> its not a reference its a value which is passed
   // Java passes references by value. What this means is that you can legitimately call mutating methods on the parameters of a method,
    // but you cannot reassign them and expect the value to propagate.
    public static void foo(Dog d) {
        d.getName().equals("Max"); // true

        // by value
        //        d = new Dog("Fifi");
        //        d.getName().equals("Fifi"); // true

        // by reference (java named pointers references)
        d.setName("Fifi");
    }

    static class Dog {

        String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
