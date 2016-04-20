package services.book.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Adrian on 4/20/2016.
 */
public class NIO {



    // way to do with java 8 with checked exception
    private static void java8SuperShortWay(Path input) throws IOException {

        // to find out working directory
        String cwd = new File(".").getAbsolutePath();
        System.out.println(cwd);
        String content = new String(Files.readAllBytes(Paths.get("services/src/main/java/services/book/util/testInput.txt")));

        // lets split and trim the first lines
        String [] elements = content.split("#");
        String effectiveContent = elements[7].trim();
        System.out.println(effectiveContent);

    }


    public static void main(String[] args) {


        try {
            java8SuperShortWay(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
