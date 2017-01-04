package ch.adriankrebs.services.book.util.MultiThreading;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Adrian on 1/3/2017.
 */
public class ForkJoinSample {

    //recursive tasks i.e fibonacci
    // kind of divide and conquer

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci(10);
        System.out.println(fibo.compute());
        System.out.println(fib(8));
    }

    static Long fib(long n) {
        if (n <= 1) {
            return n; // base case
        }
        return fib(n - 1) + fib(n - 2);
    }

    static class Fibonacci extends RecursiveTask<Long> {
        private final long n;

        Fibonacci(long n) {
            this.n = n;
        }

        public Long compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }



}
