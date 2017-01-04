package ch.adriankrebs.services.book.util.IO;

import java.io.*;

/**
 * Created by Adrian on 1/4/2017.
 */
public class Streams {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        In this example, FileInputStream is the low-level stream that interacts directly with
        the file, which is wrapped by a high-level BufferedInputStream to improve performance.
        Finally, the entire object is wrapped by a high-level ObjectInputStream, which allows us to
        filter the data as Java objects.

         */

        try (ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("zoo-data.txt")))) {
            System.out.println(objectStream.readObject());

        }



        InputStream is = new BufferedInputStream(new FileInputStream("test.txt"));
        System.out.print ((char)is.read());
        if(is.markSupported()) {
            is.mark(100);
            System.out.print((char)is.read());
            System.out.print((char)is.read());
            is.reset(); // resets pointer to and reads first characters again
        }
        System.out.print((char)is.read());
        System.out.print((char)is.read());
        System.out.print((char)is.read());
    }
}
