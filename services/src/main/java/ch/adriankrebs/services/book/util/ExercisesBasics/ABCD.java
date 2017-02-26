package ch.adriankrebs.services.book.util.ExercisesBasics;

/**
 * Created by Adrian on 2/12/2017.
 */
public class ABCD
{
    protected int i = 10;
    public int getI() { return i; }


    @Override
    public boolean equals(Object o) throws NullPointerException{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ABCD abcd = (ABCD) o;

        return i == abcd.i;
    }

    @Override
    public int hashCode() {
        return i;
    }
}

