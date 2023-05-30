package lab6.app1lab7.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadExecution extends Thread {
    Integer[] monitor;
    int[] activity1, activity2;
    int sleep;
    int permit;
    Semaphore[] semaphore;

    public ThreadExecution(Integer[] monitor, int sleep, int[] activity1, int[] activity2, int permit, Semaphore[] semaphore) {

        this.monitor = monitor;
        this.sleep = sleep;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.permit = permit;
        this.semaphore = semaphore;


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
            try {
                this.semaphore[0].acquire(this.permit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
      //      System.out.println(this.getName() + " - TRANSITION 2 - 3");

            try {
                this.semaphore[1].acquire(this.permit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    //        System.out.println(this.getName() + " - TRANSITION 3 - 4");
            try {
                Thread.sleep(sleep * 500);
            } catch (Exception e) {

            }
            this.semaphore[0].release();
            this.semaphore[1].release();

        }

        if (this.getName().equals("Thread-1")) {
            try {
                this.semaphore[1].acquire(this.permit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
        //        System.out.println(this.getName() + " - TRANSITION 2 - 3");

            try {
                this.semaphore[0].acquire(this.permit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

                System.out.println(this.getName() + " STATE 3");
                try {
                    Thread.sleep(sleep);
                } catch (Exception e) {

                }
            this.semaphore[0].release();
            this.semaphore[1].release();
            }



        System.out.println(this.getName() + " - STATE 4");
    }
}
