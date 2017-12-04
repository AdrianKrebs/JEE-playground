package ch.adriankrebs.services.book.rmi;

import javax.ejb.Remote;

@Remote
public interface Hello {

    public String sayHello(String name);
}
