package ch.adriankrebs.services.book.util.IO;

import ch.adriankrebs.services.book.util.ExercisesBasics.ABCD;

/**
 * Created by Adrian on 2/12/2017.
 */
public class EFG extends ABCD {

    public void process(ABCD a)
    {
        i = i*2; // a.i requires world access, i uses the variable in the superclass ABCD and is valid because subclass outside package are allowed to access
    }
    public static void main(String[] args)
    {
        ABCD a = new EFG();
        EFG b = new EFG();
        b.process(a); // changes variable of b, not a
        System.out.println( b.getI() );
    }


}
