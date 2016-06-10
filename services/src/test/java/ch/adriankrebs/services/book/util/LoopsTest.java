package ch.adriankrebs.services.book.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by U116523 on 18.04.2016.
 */
public class LoopsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void twoWaysToIncrement() throws Exception {

        //GIVEN
        List<String> programmers = Arrays.asList("first","second","third");

        // WHEN
        twoWaysToIncrement();

        //THEN
        Assert.assertNotNull(programmers);

    }

    @Test
    public void loopStatements() throws Exception {

    }

}