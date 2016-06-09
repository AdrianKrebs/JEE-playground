package services.book.util;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by U116523 on 09.06.2016.
 */
public class StringTest {


    @Test
    public void shouldGetCorrectFileStrings() {

        //given
        final String FPATH = "/home/user/index.html";
        // different chars as extractors
        Strings.Filename myHomePage = new Strings.Filename(FPATH, '/', '.');

        // when
        String extractedExtension = myHomePage.extension();
        String filename = myHomePage.filename();
        String path = myHomePage.path();


        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());


        //then
        assertThat(extractedExtension, is("html"));
        assertThat(filename, is("index"));
        assertThat(path, is("/home/user"));


    }


    @Test
    public void shouldFindString() {

        //given
        String stringToFind  = "Eggs";
        String stringToSearch = "Green Eggs and Ham";

        //when
        Boolean found = Strings.findStringInString(stringToSearch,stringToFind);

        //then
        assertTrue(found);
    }


    // Quiz


    @Test
    public void exercise1() {
        String hi = "Hi, ";
        String mom = "mom.";

        System.out.println(hi.concat(mom));

        System.out.println(new StringBuilder(hi).append(mom));
    }

    @Test
    public void initialsOfFullName() {
       String fullName = "Adrian Krebs";

        System.out.println(fullName.charAt(0) + "." + fullName.split("\\s")[1].charAt(0));
    }

    @Test
    public void anagram() {
        String original = "software";
        String anagramOfIt = "swear oft";

        //Ternary operators can't have statements that don't return values, void methods


        char[] word1 = original.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = anagramOfIt.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);


        System.out.println( Arrays.equals(word1,word2) ? "yes "+ anagramOfIt+ " is an anagram of "+ original : "no "+ anagramOfIt+ " is NOT an anagram of "+ original);
        // check for containing same letters

        ;
    }



}
