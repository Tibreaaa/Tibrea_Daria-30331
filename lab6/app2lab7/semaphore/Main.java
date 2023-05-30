package lab6.app2lab7.semaphore;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {


        Semaphore s0 = new Semaphore(1);
        Semaphore s1 = new Semaphore(1);
        Semaphore[] semaphores = new Semaphore[]{s0,s1};
        CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {
            public void run() {

                System.out.println("exited " );
            } });
        new ThreadExecution( 4, 2, 4,1,semaphores,bariera).start();
        new ThreadExecution( 3,3,6,1,semaphores,bariera).start();
        new ThreadExecution( 5,2,5,1,semaphores,bariera).start();


    }

}
