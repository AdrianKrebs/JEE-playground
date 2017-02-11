package ch.adriankrebs.services.book.util.MultiThreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Adrian on 2/11/2017.
 */
public  class LockExamples {
    private Map<String, Integer> marksObtained = new HashMap<String, Integer>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void setMarksInSubject(String subject, Integer marks){
        // valid code to set marks for a given subject
    }
    public double getAverageMarks(){

        //1 - INSERT CODE HERE
        lock.readLock().lock();

        double sum = 0.0;
        try{
            for(Integer mark : marksObtained.values()){
                sum = sum + mark;
            }
            return sum/marksObtained.size();
        }finally{

            //2 - INSERT CODE HERE
            lock.readLock().unlock();

        }
    }

    public static void main(String[] args) {
        // THread safe random number generation
        int r = ThreadLocalRandom.current().nextInt(1, 11);


    }

}
