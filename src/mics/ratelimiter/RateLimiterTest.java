//package mics;
//
//import org.junit.Assert;
//import org.junit.Foo;
//import org.mq.code.RateLimiter1.RateLimiter;
//
//public class RateLimiterTest {
//    @Foo
//    public void shouldReturnTrueIfAllowed() {
//        RateLimiter rateLimiter = new RateLimiter(3, 1000);
//        long currentTimestamp = System.currentTimeMillis();
//
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp));
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 300));
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 700));
//        Assert.assertFalse(rateLimiter.isAllowed("client1", currentTimestamp + 700));
//        Assert.assertFalse(rateLimiter.isAllowed("client1", currentTimestamp + 700));
//
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 1001));
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 1500));
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 1800));
//        Assert.assertTrue(rateLimiter.isAllowed("client1", currentTimestamp + 2002));
//
//    }
//}
