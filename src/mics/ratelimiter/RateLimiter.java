package mics.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private final int requestLimit;
    private final long timeLimit;
    private final ConcurrentHashMap<String, HitCounter> rateLimiterMap;

    public RateLimiter(int requestLimit, long timeLimit) {
        this.rateLimiterMap = new ConcurrentHashMap<>();
        this.requestLimit = requestLimit;
        this.timeLimit = timeLimit;
    }

    public boolean isAllowed(String clientId, long currentTimestamp) {
        HitCounter hitCounter;

        if (!rateLimiterMap.containsKey(clientId)) {
            hitCounter = new HitCounter(requestLimit, timeLimit);
            rateLimiterMap.put(clientId, hitCounter);
        } else {
            hitCounter = rateLimiterMap.get(clientId);
        }

        return hitCounter.hit(currentTimestamp);
    }
}

class HitCounter {
    private final Queue<Long> queue;
    private final int requestLimit;
    private final long timeLimit;

    public HitCounter(int requestLimit, long timeLimit) {
        this.queue = new LinkedList<>();
        this.requestLimit = requestLimit;
        this.timeLimit = timeLimit;
    }

    public boolean hit(long timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() > timeLimit) {
            queue.poll();
        }

        if (queue.size() < requestLimit) {
            queue.offer(timestamp);

            return true;
        }

        return false;
    }
}


