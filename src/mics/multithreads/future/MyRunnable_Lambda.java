package mics.multithreads.future;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable_Lambda {

    public static void main(String[] args) {
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //return the thread name executing this callable task
                System.out.println(new Date() + "::" + Thread.currentThread().getName());
            });
        }


        //shut down the executor service now
        executor.shutdown();
    }

}
