package ch.adriankrebs.services.book.util.ExercisesBasics.client;

import java.net.Socket;

/**
 * Created by Adrian on 1/18/2017.
 */
public class SubClient extends Client {
    public SubClient(Socket s) {
        super(s);
        // here i can access the test method because its package private (default)
        super.accessorTest();

    }
}
