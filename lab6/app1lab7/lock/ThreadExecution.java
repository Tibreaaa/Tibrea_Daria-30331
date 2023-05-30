package lab6.app1lab7.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class ThreadExecution extends Thread {

    int[] activity1, activity2;
    int sleep;

    Lock[] lock;

    public ThreadExecution( int sleep, int[] activity1, int[] activity2,  Lock[] lock) {

        this.sleep = sleep;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.lock = lock;


    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[1]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
     //   System.out.println(this.getName() + " - TRANSITION 1 - 2");
        if (this.getName().equals("Thread-0")) {
            this.lock[0].lock();
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
      //      System.out.println(this.getName() + " - TRANSITION 2 - 3");

            this.lock[1].lock();
    //        System.out.println(this.getName() + " - TRANSITION 3 - 4");
            try {
                Thread.sleep(sleep * 500);
            } catch (Exception e) {

            }
            this.lock[0].unlock();
            this.lock[1].unlock();

        }

        if (this.getName().equals("Thread-1")) {
            this.lock[1].lock();
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
        //        System.out.println(this.getName() + " - TRANSITION 2 - 3");

            this.lock[0].lock();

                System.out.println(this.getName() + " STATE 3");
                try {
                    Thread.sleep(sleep);
                } catch (Exception e) {

                }
            this.lock[0].unlock();
            this.lock[1].unlock();
            }
        System.out.println(this.getName() + " - STATE 4");
    }
}
