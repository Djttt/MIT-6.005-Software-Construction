/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.*;

import org.junit.Test;

public class SocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     *
     * Partition the input tweets
     * tweets size: 0, 1, >1
     * return map size: 0, 1, > 1
     *
     *
     *
     * Partition input as followed
     * followsGraph size: 0, 1, > 1
     *
     *
     */

    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");

    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?@qqq @kkk_ki223", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype @qqq", d2);
    private static final Tweet tweet3 = new Tweet(3, "bbitdiddle", "rivest talk in 30 minutes @hype_wowouo", d2);
    private static final Tweet tweet4 = new Tweet(4, "bbitdiddle", "rivest talk in 30 minutes hi world! @kkk_ki223", d2);
    private static final Tweet tweet5 = new Tweet(5, "Andrew", "rivest talk in 30 minutes kulll@mid.edu hi this @kkk_ki223 hihi", d2);


    private static final Tweet tweet6 = new Tweet(6, "22", "rivest talk in 30 minutes @33 @kk", d2);
    private static final Tweet tweet7 = new Tweet(7, "33", "rivest talk in 30 minutes hi world! @44", d2);
    private static final Tweet tweet8 = new Tweet(8, "44", "rivest talk in 30 minutes kulll@mid.edu hi this @kk hihi", d2);
    private static final Tweet tweet9 = new Tweet(9, "kk", "rivest talk in 30 minutes hi world! @dj", d2);

    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }

    @Test
    public void testGuessFollowsGraph() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4, tweet5));
        assertFalse("expected non-empty graph", followsGraph.isEmpty());
        assertTrue("expected contains kkk_ki223", followsGraph.get("kkk_ki223").contains("Andrew"));
        assertTrue("expected contains", followsGraph.get("hype22").containsAll(Arrays.asList("bbitdiddle")));
        assertTrue("expected contains", followsGraph.get("Andrew")==null);
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
    }

    @Test
    public void testInfluencersNonEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4, tweet5));
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        assertEquals("expect bbitdiddle", Arrays.asList("kkk_ki223", "qqq", "hype_wowouo"), influencers);
    }

    @Test
    public void guessFollowsGraphByAwareness() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet6, tweet7, tweet8));
        Set<String> expected = new HashSet<>(Arrays.asList("33", "22"));
        assertEquals("expected contains", expected, followsGraph.get("44"));
    }

    @Test
    public void guessFollowsGraphByAwareness2() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet6, tweet7, tweet8, tweet9));
        Set<String> expected = new HashSet<>(Arrays.asList("kk", "22", "44", "33"));
        assertEquals("expected contains", expected, followsGraph.get("dj"));
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
