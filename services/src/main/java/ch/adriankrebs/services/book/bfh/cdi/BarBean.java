package ch.adriankrebs.services.book.bfh.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;

/**
 * Created by Adrian on 10/23/2017.
 */

public class BarBean {
    @Inject
    FooBean fooBean; //Bean ist in SE im Prinzip normale Klasse. Ist aber eigentlich Komponente weil Bean eigentlich nichts aussagt


    public void sayHelloWorld() {
         fooBean.sayHello();
    }

    public static void main(String[] args) {

        //Start weld container
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BarBean application = container.instance().select(BarBean.class).get();
        application.sayHelloWorld();
        weld.shutdown();
    }


}
