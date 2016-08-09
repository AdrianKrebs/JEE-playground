package ch.adriankrebs.services.book.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 8/5/2016.
 */
public class DataStructures {


    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();
        List s1 = new ArrayList( );
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s1.add("a");
        if(s1.remove("a")){
            if(s1.remove("a")){
                s1.remove("b");
            }else{
                s1.remove("c");
            }
        }
        System.out.println(s1);

        // --> c


   /*     ArrayList's remove(Object ) method removes the first occurence of the given element and returns true if found.
        It does not remove all occurences of the element. In this case, the first call to s1.remove("a"); will remove only the first "a"
        and return true, the second call to remove("a") will remove the second "a" and return true.
                Finally, the call to remove("b") will remove "b". Therefore, only "c" will be left in the list.
*/

        /*
        order
        ---------------------
        Both an array and ArrayList are ordered and have indexes.


        */



        /*
        equality
        -----------------------------
        An array does not override equals() and so uses object equality. ArrayList does
        override equals() and defines it as the same elements in the same order.


         */

        int[] eqTester = {1, 2, 3};
        int [] eqTester2 = {1,2,3};

        System.out.println(eqTester == eqTester2); // false


        /*
        searching
        ---------------------------------
         an array must be sorted for binarySearch() to return a meaningful result.


           Remember that numbers sort before
           letters and strings sort alphabetically. This makes 30 come before 8. A binary search
           correctly finds 8 at index 2 and 3A at index 1. It cannot find 4F but notices it should
           be at index 2. The rule when an item isn’t found is to negate that index and subtract 1.
           Therefore, we get –2–1, which is –3.

           Here a more mathematical way of seeing it, though not really complicated. IMO much clearer as informal ones:

            The question is, how many times can you divide N by 2 until you have 1? This is essentially saying, do a binary search (half the elements) until you found it. In a formula this would be this:

            1 = N / 2x
            multiply by 2x:

            2x = N
            now do the log2:

            log2(2x)    = log2 N
            x * log2(2) = log2 N
            x * 1         = log2 N
            this means you can divide log N times until you have everything divided. Which means you have to divide log N ("do the binary search step") until you found your element.
         */


        List<String> hex = Arrays.asList("30", "8", "3A", "FF");
        Collections.sort(hex);
        int x = Collections.binarySearch(hex, "8");
        int y = Collections.binarySearch(hex, "3A");
        int z = Collections.binarySearch(hex, "4F");
        System.out.println(x + " " + y + " " + z);






    }
}
