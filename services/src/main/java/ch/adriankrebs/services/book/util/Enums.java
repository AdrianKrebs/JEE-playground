package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 9/20/2016.
 */
public enum Enums {

    WINTER{
        @Override
        public void printHours() {
            System.out.println("opening hours are 8 -12 am");
        }
    }, SPRING, SUMMER, FALL; //<--- only needed when more than just declaration


    public static enum TestEnum {A, B, C}; // enums are static anyway. enum declaration in method bodies or constructors are not allowed
    public void printHours() {
        System.out.println("opening hours are 9 am - 2 pm");
    }

}
