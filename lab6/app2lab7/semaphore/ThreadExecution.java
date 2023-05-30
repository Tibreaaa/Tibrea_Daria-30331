package lab6.app2lab7.semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ThreadExecution extends Thread {

    int activity_min, activity_max;
    int sleep;
    int permit;
    Semaphore[] semaphores;
    CyclicBarrier barrier;

    public ThreadExecution(int sleep, int activity_min, int activity_max,
                           int permit, Semaphore[] semaphores, CyclicBarrier barrier) {

        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.semaphores = semaphores;
        this.permit = permit;
        this.barrier = barrier;
    }

    public void run() {

        while (true) {
            if (this.getName().equals("Thread-0")) {
                System.out.println(this.getName() + " - STATE 1");
                try {
                    this.semaphores[0].acquire(this.permit);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.semaphores[0].release();
                System.out.println(this.getName() + " - STATE 3");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }


            if (this.getName().equals("Thread-1")) {
                System.out.println(this.getName() + " - STATE 1");
                try {
                    this.semaphores[0].acquire(this.permit);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.semaphores[1].acquire(this.permit);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.semaphores[0].release();
                this.semaphores[1].release();
                System.out.println(this.getName() + " - STATE 3");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }


            if (this.getName().equals("Thread-2")) {
                System.out.println(this.getName() + " - STATE 1");
                try {
                    this.semaphores[1].acquire(this.permit);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.semaphores[1].release();
                System.out.println(this.getName() + " - STATE 3");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
