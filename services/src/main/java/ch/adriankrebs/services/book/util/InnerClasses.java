package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 2/25/2017.
 */
public class InnerClasses {

    public static void main(String args[] )
    {
        Outer2 out = new Outer2();
        System.out.println(out.getInner().getOi());
    }
}
class Outer2
{
    private int oi = 20;
    class Inner
    {
        int getOi() { return oi; }
    }
    Inner getInner() { return new Inner() ; }
}