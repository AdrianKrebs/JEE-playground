package ch.adriankrebs.services.book.bfh.cdi;

import javax.enterprise.inject.Produces;

/**
 * Created by Adrian on 10/23/2017.
 */

public class FooBean {


    public void  sayHello() {
        System.out.println("Hello World");
    }

    @Produces
    @Preferred
    public FooBean getFooStrategy() {
        return new FooBean();
        }

    }
