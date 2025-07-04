/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {


    /**
     * one people followed other by he mentioned it.
     * @param tweets a list of tweet
     * @return a social network (as defined above) in which Ernie follows Bert
     *               if and only if there is evidence for it in the given list of
     *               tweets.
     */
    private static Map<String, Set<String>> influenceByMentioned(List<Tweet> tweets) {
        Map<String, Set<String>> gussFollowed = new HashMap<>();

        for (Tweet tweet : tweets) {
            String author = tweet.getAuthor();
            Set<String> mentionedUser = Extract.getMentionedUsers(Collections.singletonList(tweet));

            for (String userName : mentionedUser) {
                if (gussFollowed.get(userName) == null) {
                    Set<String> followedUser = new HashSet<>();
                    followedUser.add(author);
                    gussFollowed.put(userName, followedUser);
                }
                else {
                    Set<String> followedUser = gussFollowed.get(userName);
                    followedUser.add(author);
                }
            }
        }
        return gussFollowed;
    }


    /**
     * one people followed other by awareness it.(If A follows B and B follows C, then A probably follows C)
     * @param tweets a list of tweet
     * @return a social network defined by awareness.
     */
    private static Map<String, Set<String>> influenceByAwareness(List<Tweet> tweets) {
        Map<String, Set<String>> gussFollowed = influenceByMentioned(tweets);

        Map<String, Set<String>> newGussFollowed = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : gussFollowed.entrySet()) {
            newGussFollowed.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }

        for (String a : newGussFollowed.keySet()) {
            Set<String> aFollows = newGussFollowed.get(a);
            for (String b : aFollows) {
                if (newGussFollowed.containsKey(b)) {
                    Set<String> cFollows = newGussFollowed.get(b);
                    for (String c : cFollows) {
                        if (!a.equals(c)) {
                            aFollows.add(c);
                        }
                    }
                }
            }
        }
        return newGussFollowed;
    }

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        Map<String, Set<String>> gussFollowed = influenceByAwareness(tweets);
        return gussFollowed;
    }


    private static Map<String, Set<String>> sortedFollowsGraph(Map<String, Set<String>> followsGraph) {
        // Step 1: Convert map to list of entries
        List<Map.Entry<String, Set<String>>> entryList = new ArrayList<>(followsGraph.entrySet());

        // Step 2: Sort the list by values
        Collections.sort(entryList, new Comparator<Map.Entry<String, Set<String>>>() {
            public int compare(Map.Entry<String, Set<String>> e1, Map.Entry<String, Set<String>> e2) {
                return e2.getValue().size() - e1.getValue().size(); // ascending
            }
        });

        // Step 3: Put sorted entries into a LinkedHashMap
        Map<String, Set<String>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        List<String> descendInfluenceList = new ArrayList<>();
        Map<String, Set<String>> sortedMap = sortedFollowsGraph(followsGraph);
        for (String key : sortedMap.keySet()) {
            descendInfluenceList.add(key);
        }
        return descendInfluenceList;
    }

}
