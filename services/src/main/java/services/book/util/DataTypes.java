package services.book.util;

/**
 * Created by U116523 on 19.04.2016.
 */
public class DataTypes {

    public static void main(String[] args) {

        // prints binary
        System.out.println(Integer.toBinaryString(0b100001011));

        // prints decimal
        System.out.println(0b100001011);

        // underscore in literal numbers -> not allowed before prefix. at the end and at the beginning A-F in hex
        // prefix hex -> 0x
        // prefix bin -> 0b
        // prefix oct -> 0
        System.out.println(0x4_13);

        // ------ Difference primitives and reference variables----------
        //      The basic difference is that primitive
        //        variables store the actual values, whereas reference variables store the addresses of the
        //        objects they refer to.

        boolean b1, b2, b3, b4, b5, b6; // line 1
        b1 = b2 = b3 = true; // allowed because same type


//   (superclass)                                        Number
                            //                   __________/\__________
                            //                /       |      |       \
//   (concrete subclasses)               Integer   Long    Float   Double



    }
}
