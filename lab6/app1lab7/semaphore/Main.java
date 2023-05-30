package lab6.app1lab7.semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Integer[] monitor = { 0, 1};
        Semaphore s0 = new Semaphore(1);
        Semaphore s1 = new Semaphore(1);
        Semaphore[] semaphores = new Semaphore[]{s0,s1};
        int[] activity1 = { 2, 4 };
        int[] activity2 = { 4, 6 };
        int[] activity3 = { 3, 5 };
        int[] activity4 = { 5, 7 };

        new ThreadExecution(monitor, 4, activity1, activity2,1,semaphores).start();
        new ThreadExecution(monitor, 5, activity3, activity4,1,semaphores).start();
    }
}
