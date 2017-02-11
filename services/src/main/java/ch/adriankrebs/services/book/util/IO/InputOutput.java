package ch.adriankrebs.services.book.util.IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Adrian on 1/4/2017.
 */
public class InputOutput {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        In this example, FileInputStream is the low-level stream that interacts directly with
        the file, which is wrapped by a high-level BufferedInputStream to improve performance.
        Finally, the entire object is wrapped by a high-level ObjectInputStream, which allows us to
        filter the data as Java objects.

         */

        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println ("You entered the following: "+userInput);
        }

        try (ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("zoo-data.txt")))) {
            System.out.println(objectStream.readObject());

        }


        InputStream is = new BufferedInputStream(new FileInputStream("test.txt"));
        System.out.print((char) is.read());
        if (is.markSupported()) {
            is.mark(100);
            System.out.print((char) is.read());
            System.out.print((char) is.read());
            is.reset(); // resets pointer to and reads first characters again
        }
        System.out.print((char) is.read());
        System.out.print((char) is.read());
        System.out.print((char) is.read());


        File source = new File("Zoo.class");
        File destination = new File("ZooCopy.class");
        copyByteContentSlowly(source, destination);



        Stream<String> lines = Files.lines(Paths.get("test.txt"), Charset.defaultCharset());
        lines.forEach(s -> System.out.println(s));




    }


    /**
     * We read byte by byte and write it
     *
     * @param source
     * @param destination
     * @throws IOException
     */
    public static void copyByteContentSlowly(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            int b; // read returns an integer instead of a byte because we need a negative value to indicate the end of the file
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }


    /**
     * Now we use buffered stream which use byte[]. this results in performance improvements
     * Instead of doing many round trips to the file system. BufferedStreams use memory space.
     *
     * @param source
     * @param destination
     * @throws IOException
     */
    public static void copyByteContentFast(File source, File destination) throws IOException {
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush(); //to ensure that the written data actually makes it to disk before the next buffer of data is read.
            }
        }
    }


    class CloseableTester implements AutoCloseable{

        @Override
        public void close() throws Exception {

        }
    }

}
