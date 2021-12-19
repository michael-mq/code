package mics.multithreads.ScatterGather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorLatch {
    public Set<Integer> getPrices(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3);

        threadPool.submit(new Task(prices, "https://abc", 1234, latch));
        threadPool.submit(new Task(prices, "https://abc", 1234, latch));
        threadPool.submit(new Task(prices, "https://abc", 1234, latch));

        latch.await(3, TimeUnit.SECONDS);

        return prices;
    }

    private class Task implements Runnable {
        private Set<Integer> prices;
        private String url;
        private int productId;
        private CountDownLatch latch;

        public Task(Set<Integer> prices, String url, int productId, CountDownLatch latch) {
            this.prices = prices;
            this.url = url;
            this.productId = productId;
            this.latch = latch;
        }

        @Override
        public void run() {
            int price = 0;
            prices.add(price);
            // make http call
            latch.countDown();
        }
    }
}
