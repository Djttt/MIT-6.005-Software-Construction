/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ExtractTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     * Test Strategy
     *
     * Partition the inputs as follows:
     * tweets.length: 0, 1, >1
     *
     *
     * Partition the input as follows:
     * mentionedUser: 0, 1, >1
     * tweet's text:  0, 1, 1 < mentionedUser < n (n can be very large number)
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);

    private static final Tweet tweet3 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @hype", d2);
    private static final Tweet tweet4 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @hype_wowouo hi world! @Deng @djttt", d2);

    private static final Tweet tweet5 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes kulll@mid.edu hi this @kkk_ki223 hihi", d2);

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // covers tweets.length > 1
    @Test
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2));
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d2, timespan.getEnd());
    }

    // covers tweets.length = 0
    @Test
    public void testGetTimespanEmptyTweets() {
        assertThrows(AssertionError.class, () -> {
            Extract.getTimespan(new ArrayList<>());
        });
    }

    //covers tweets.length = 1
    @Test
    public void testGetTimespanOneTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1));
        assertEquals("expected start", d1, timespan.getStart());

        timespan = Extract.getTimespan(Arrays.asList(tweet2));
        assertEquals("expected end", d2, timespan.getEnd());
    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1));

        assertTrue("expected empty set", mentionedUsers.isEmpty());
    }

    @Test
    public void testGetMentionedUsersOneMention() {
        Set<String> actual = Extract.getMentionedUsers(Arrays.asList(tweet3));
        Set<String> expected = new HashSet<>(Arrays.asList("hype"));
        assertEquals("Sets should be equal", expected, actual);
    }

    @Test
    public void testGetMentionedUsersManyMention() {
        Set<String> actual = Extract.getMentionedUsers(Arrays.asList(tweet4));
        Set<String> expected = new HashSet<>(Arrays.asList("hype_wowouo", "deng", "djttt"));

        assertEquals("Sets should be equal", expected, actual);

    }

    @Test
    public void testGetMentionedUsersIllegalMention() {
        Set<String> actual = Extract.getMentionedUsers(Arrays.asList(tweet5));
        Set<String> expected = new HashSet<>(Arrays.asList("kkk_ki223"));
        assertEquals("Sets should be equal", expected, actual);

    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */

}
