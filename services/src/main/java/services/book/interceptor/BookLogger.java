/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services.book.interceptor;

import services.book.boundary.BookService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 *
 * @author Juneau
 */
@Interceptor
@NewLoggable
@Priority(200)
public class BookLogger implements Serializable {
    @Inject
    BookService bookService;

    @AroundInvoke
    public Object saveBook(InvocationContext ctx) throws Exception {
        
            // normally write to a formal log
            System.out.println("New book submitted");
       return ctx.getTarget();
    }
}
