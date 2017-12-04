package ch.adriankrebs.services.book.rmi;


import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class HelloBeanIT {

@Test
 public void invokeHello() throws NamingException {

    Context jndiContext = new InitialContext();
     Hello helloProxy = (Hello) jndiContext.lookup("java:global/hello/HelloService");

     String remoteString = helloProxy.sayHello("Adrian");

     System.out.println(remoteString);
 }
}