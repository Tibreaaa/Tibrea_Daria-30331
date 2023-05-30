package lab6.app1lab7.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Integer[] monitor = { 0, 1};
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock[] locks = new Lock[]{lock1,lock2};
        int[] activity1 = { 2, 4 };
        int[] activity2 = { 4, 6 };
        int[] activity3 = { 3, 5 };
        int[] activity4 = { 5, 7 };

        new ThreadExecution( 4, activity1, activity2,locks).start();
        new ThreadExecution(5, activity3, activity4,locks).start();
    }
}
