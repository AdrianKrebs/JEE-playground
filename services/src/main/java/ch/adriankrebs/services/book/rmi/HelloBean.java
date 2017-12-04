package ch.adriankrebs.services.book.rmi;

import javax.ejb.Stateless;


@Stateless(name = "HelloService")
public class HelloBean implements Hello{

    public String sayHello(String name) {
        return "Hello "+ name + " from remote Bean!";
    }

}
