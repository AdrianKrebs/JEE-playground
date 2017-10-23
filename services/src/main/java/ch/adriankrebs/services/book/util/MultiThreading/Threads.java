package ch.adriankrebs.services.book.util.MultiThreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Adrian on 12/29/2016.
 */
public class Threads {
    int counter;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));

            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask(c1, c2));
        } finally {
            if (service != null) service.shutdown();
        }



        //create and start a Thread

        // either extends Thread
        (new ReadInventoryThread()).start();

        // or implement Runnable. BUT then you have to create a new Thraed
        new Thread(new PrintData()).start();


       // Callable is intended to wait for a result (Future) and therefore used in combination with an executor service:
        try {
            ExecutorService service2 = Executors.newSingleThreadExecutor();
            service2.submit(new CoffeeService());
        }
        finally {
            service.shutdown();
        }


        A a = new A();
        a.start();
        Thread.sleep(1000);
        a.interrupt();


        Threads t = new Threads();
        System.out.println(t.counter++);


        int threadSafeRandom = ThreadLocalRandom.current().nextInt(1,11);
    }


    static class A extends Thread
    {
        public void run()
        {
            System.out.println("Starting loop");
            try{
                while(!isInterrupted()) { }
            }catch(Exception e){ e.printStackTrace(); }
            System.out.println("Ending loop");
        }
    }

    public static synchronized void executerServiceTester() throws InterruptedException {

        AtomicInteger integer = new AtomicInteger();
        integer.incrementAndGet();
        integer.getAndIncrement();
        integer.compareAndSet(0,1);
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            // callable or runnable -> difference is exception or not
            service.submit(() -> {
                Thread.sleep(2000);
                return null;
            });
        } finally {
            if (service != null) service.shutdown();
        }

        // if we don't need the result we can add wait like this for all tasks to be finished:
        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            // Check whether all tasks are finished
            if (service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }

        // by calling the static factory method u can create a scheduled thread executor
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // works only with Runnable and not Callable
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.printf("teeest"),0,2,TimeUnit.MINUTES);
        // every object be synchronized
        Integer manager = 5;
        synchronized (manager) {
            // Work to be completed by one thread at a time
            // first thread acquires the lock
        }

    }

    static class PrintData implements Runnable {
        public void run() {
            for(int i=0; i<3; i++)
                System.out.println("Printing record: "+i);
        }
    }
    static class ReadInventoryThread extends Thread {
        public void run() {
            System.out.println("Printing zoo inventory");
        }
    }

    static class CoffeeService implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "serving some coffee for the hard working zoo employees";
        }
    }

    static class LionPenManager {
        private void removeAnimals() {
            System.out.println("Removing animals");
        }

        private void cleanPen() {
            System.out.println("Cleaning the pen");
        }

        private void addAnimals() {
            System.out.println("Adding animals");
        }

        public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
            try {
                removeAnimals();
                c1.await();
                cleanPen();
                c2.await();
                addAnimals();
            } catch (InterruptedException | BrokenBarrierException e) {
               // e = new InterruptedException("werw"); reassigning is not allowed because final 
// Handle checked exceptions here
            }
        }
    }
}

interface Eatable{
}
class Food implements Eatable {
    public static int types = 20;
}
 class Fruit extends Food implements Eatable{  //LINE1

    public static void main(String[] args) {
         types = 30; //LINE 2
        System.out.println(types); //LINE 3
    }
}

 class TestClass extends Thread
{
    private static int threadcounter = 0;
    public synchronized void run()
    {
        threadcounter++;
        System.out.println(threadcounter);
    }
    public static void main(String[] args) throws Exception
    {
        for(int i=0; i<5; i++)
        {
            new TestClass().start();
        }
        System.out.println(threadcounter+" DONE");
    }
}


class Counter
{
    public int startHere = 1;
    public int endHere = 100;
    public static void main(String[] args)
    {
        new Counter().go();
    }
    void go()
    {
        Thread a = new Thread()
        {
            public void run()
            {
                for (int i = startHere; i <= endHere; i++){ System.out.println(i); }
            }
        };
        Thread t = new Thread(a); // this works perfectly fine since thread implements runnable and the thread constructor takes a runanble
        t.start();

    }
}

