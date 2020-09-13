package Year2019.November.day04;

import java.util.*;

/**
 * @题目 ： 355. Design Twitter
 * @Data 19/11/12
 * @题目描述： Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * @题目链接： 链接：https://leetcode-cn.com/problems/design-twitter
 * @示例1: ######
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * @示例2: ######
 * @示例3: ###
 */

public class DesignTwitter {

    class Twitter {
        //用户关注
        Map<Integer, Set<Integer>> userFollows;
        //用户发布的推特
        List<int[]> tweets;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userFollows = new HashMap<>();
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
            for (int i = tweets.size() - 1; i >= 0; i--) {
                int[] tweet = tweets.get(i);
                //使用getOrDefault防止出现用户没有关注其他用户导致空指针的情形
                if(userId == tweet[0] || userFollows.getOrDefault(userId,new TreeSet<>()).contains(tweet[0])){
                    res.add(tweet[1]);
                    if(res.size() >= 10)
                        break;
                }
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!userFollows.containsKey(followerId))
                userFollows.put(followerId, new TreeSet<>());
            userFollows.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            //防止get操作返回空指针
            if (userFollows.containsKey(followerId))
                userFollows.get(followerId).remove(followeeId);
        }
    }
}
