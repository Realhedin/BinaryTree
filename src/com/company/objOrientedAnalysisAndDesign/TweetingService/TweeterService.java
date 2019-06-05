package com.company.objOrientedAnalysisAndDesign.TweetingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dkorolev
 *         Date: 5/13/2019
 *         Time: 3:33 PM
 */
public class TweeterService {

    Map<String, List<Tweet>> userTweets = new HashMap<>();
    Map<String, List<Tweet>> hashtagTweets = new HashMap<>();

    //Fill both maps
    public synchronized void processUserTweets(List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            //fill userTweets map
            String byUser = tweet.getByUser();
            List<Tweet> tweetsByUser = userTweets.get(byUser);
            if (tweetsByUser == null) {
                userTweets.put(byUser, Arrays.asList(tweet));
            } else {
                tweetsByUser.add(tweet);
                userTweets.put(byUser, tweetsByUser);
            }
            //fill hashtagTweets map
            List<String> hashtags = tweet.getHashtags();
            for (String hashtag : hashtags) {
                List<Tweet> tweetsWithHashTag = hashtagTweets.get(hashtag);
                if (tweetsWithHashTag ==null ) {
                    hashtagTweets.put(hashtag, Arrays.asList(tweet));
                } else {
                    tweetsWithHashTag.add(tweet);
                    hashtagTweets.put(hashtag, tweetsWithHashTag);
                }
            }
        }
    }

    //remove tweets from both maps
    public void removeTweets(List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            //remove from User
            String byUser = tweet.getByUser();
            List<Tweet> tweetsByUser = userTweets.get(byUser);
            if (tweetsByUser != null) {
                tweetsByUser.remove(tweetsByUser.stream().filter(tweet.getMessage()::equals).findFirst().get());
            }
            //remove from hashTags
            List<String> hashtags = tweet.getHashtags();
            for (String hashtag : hashtags) {
                List<Tweet> tweetsByHashtag = hashtagTweets.get(hashtag);
                tweetsByHashtag.remove(tweetsByHashtag.stream().filter(tweet.getMessage()::equals).findFirst().get());
            }
        }
    }

    //return top N users with number of Tweets or top N hashtags with number of tweets
    private Map<String,Long> getTopNUsersOrHashtags(int n, Map<String,List<Tweet>> map) {
        List<String> userNamesArr = new ArrayList<>(n);
        List<Long> countsArr = new ArrayList<>(n);
        Set<Map.Entry<String, List<Tweet>>> entries = map.entrySet();
        for (Map.Entry<String, List<Tweet>> entry : entries) {
            long count = entry.getValue().stream().filter(d -> d.getDateOfTweet().isEqual(LocalDate.now())).count();
            compareWithCurrentTopUsersAndSet(userNamesArr, countsArr, count, entry.getKey());
        }
        return createMapFromLists(userNamesArr, countsArr);
    }


    // use method above
    private Map<String, Long> getTopHashTags(int n, Map<String,List<Tweet>> map) {
        return getTopNUsersOrHashtags(n, map);
    }


     ///////////////
    //help to compare with existed and replace or set if needed
    private void compareWithCurrentTopUsersAndSet(List<String>userNamesArr, List<Long> countsArr, long count, String userName) {
        for (int i = 0; i < countsArr.size(); i++) {
            if (countsArr.get(i)<count) {
                userNamesArr.set(i,userName);
                countsArr.set(i,count);
                return;
            }
        }
    }

    //create a map from 2 lists
    private Map<String, Long> createMapFromLists(List<String> userNamesArr, List<Long> countsArr) {
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < userNamesArr.size(); i++) {
            map.put(userNamesArr.get(i), countsArr.get(i));
        }
        return map;
    }
}

//only 1 class Tweet.
class Tweet {
    Long uniqId;
    String message;
    String byUser;
    List<String> hashtags;
    LocalDate dateOfTweet;

    public Long getUniqId() {
        return uniqId;
    }

    public String getMessage() {
        return message;
    }

    public String getByUser() {
        return byUser;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public LocalDate getDateOfTweet() {
        return dateOfTweet;
    }
}