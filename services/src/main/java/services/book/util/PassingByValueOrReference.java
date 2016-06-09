package services.book.util;

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
