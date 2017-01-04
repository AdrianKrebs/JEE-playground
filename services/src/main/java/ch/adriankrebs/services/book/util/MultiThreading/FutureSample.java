package ch.adriankrebs.services.book.util.MultiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Adrian on 1/3/2017.
 */
public class FutureSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> test = service.submit(() -> {
                System.out.println("test");
                return 2;
            });

            Integer integer = test.get();
            System.out.println(integer);

        }
        finally {

            // nice use of assertion
            assert service != null;
            service.shutdown();
        }









    }


}
