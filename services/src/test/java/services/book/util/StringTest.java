package services.book.util;

import org.junit.Test;

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

}
