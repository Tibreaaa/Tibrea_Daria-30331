package lab6.app2lab7.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class ThreadExecution extends Thread {

    int activity_min, activity_max;
    int sleep;
    int permit;
    Lock[] locks;
    CyclicBarrier barrier;

    public ThreadExecution(int sleep, int activity_min, int activity_max,
                           Lock[] locks, CyclicBarrier barrier) {

        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.locks = locks;
        this.barrier = barrier;
    }

    public void run() {

        while (true) {
            if (this.getName().equals("Thread-0")) {
                System.out.println(this.getName() + " - STATE 1");
                this.locks[0].lock();
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
                this.locks[0].unlock();
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
                this.locks[0].lock();
                this.locks[1].lock();
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
                this.locks[0].unlock();
                this.locks[1].unlock();
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
                this.locks[1].lock();
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
                this.locks[1].unlock();
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
