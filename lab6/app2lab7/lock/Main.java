package lab6.app2lab7.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {


        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock[] locks = new Lock[]{lock1,lock2};
        CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {
            public void run() {

                System.out.println("exited " );
            } });
        new ThreadExecution( 4, 2, 4,locks,bariera).start();
        new ThreadExecution( 3,3,6,locks,bariera).start();
        new ThreadExecution( 5,2,5,locks,bariera).start();


    }

}
