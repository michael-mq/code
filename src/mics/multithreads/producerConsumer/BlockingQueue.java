package mics.multithreads.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {
    private Queue<E> queue;
    private int size = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BlockingQueue(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();

        try {
            while (queue.size() == size) {
                notFull.await();
            }

            queue.add(e);
            System.out.println(Thread.currentThread().getName() + " is putting " + e);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();

        try {
            while(queue.size() == 0) {
                notEmpty.await();
            }

            E e = queue.poll();
            System.out.println(Thread.currentThread().getName() + " is taking " + e);
            notFull.signalAll();
            return e;

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(5);


    }
}
