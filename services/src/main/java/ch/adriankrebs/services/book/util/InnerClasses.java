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

    public static class B{

    }

    public void useClasses() {
        new Outer2.B();
        new Outer2().new Inner();
    }

    Inner getInner() { return new Inner() ; }

    public static void main(String[] args) {
        Outer2 o2 = new Outer2();

    }
}


class OuterWorld
{
    public InnerPeace i = new InnerPeace();
    private class InnerPeace
    {
        private String reason = "none";
    }
}

