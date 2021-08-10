package Algorithm.LeetCode.LeetCode_355_Design_Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {
    private final List<int[]> tweets;
    private final Map<Integer, Set<Integer>> follows;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        follows = new HashMap<>();
        tweets = new ArrayList<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> users = new HashSet<>();

        if (follows.containsKey(userId)) {
            users = follows.get(userId);
        }

        users.add(userId);

        int count = 0;

        for (int i = tweets.size() - 1; i >= 0 && count < 10; i--) {
            if (users.contains(tweets.get(i)[0])) {
                res.add(tweets.get(i)[1]);
                count++;
            }
        }

        return res;
    }

    /**
     * Follower follows a followee. addIf the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).add(followeeId);
        } else {

            follows.put(followerId, new HashSet<Integer>(Arrays.asList(followeeId)));
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            Set<Integer> followees = follows.get(followerId);
            followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
