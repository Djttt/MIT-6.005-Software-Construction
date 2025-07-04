/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        assert !tweets.isEmpty() : "List<Tweet>'s size must > 0";
        Instant start = tweets.get(0).getTimestamp();
        Instant end = tweets.get(0).getTimestamp();
        for (Tweet tweet: tweets) {
            Instant curTime = tweet.getTimestamp();
            if (curTime.isBefore(start)) {
                start = curTime;
            }
            if (curTime.isAfter(end)) {
                end = curTime;
            }
        }
        return new Timespan(start, end);
    }


    /**
     * Judge a char whether author char
     * @param ch a character
     * @return if character satisfy author's char require, then return true, else return false.
     */
    private static boolean isAuthorChar(char ch) {
        /* Rep invariant:
         *    author.length > 0
         *    all characters in author are drawn from {A..Z, a..z, 0..9, _, -}
         *    text.length <= 140
         */
        if ((ch > 'A' && ch < 'Z') || (ch > 'a' && ch < 'z') ||
                (ch > '0' && ch < '9') || ch == '_' || ch == '-') {
            return true;
        }
        return false;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        Set<String> mentionedUser = new HashSet<>();
        for (Tweet tweet : tweets) {
            // convert the string to lowercase.
            String text = tweet.getText().toLowerCase();
            for (int i = 0; i < text.length(); i+=1) {
                int startPos;
                int endPos;
                if (text.charAt(i) == '@') {
                    if (i - 1 > 0) {
                        char preMentionedChar = text.charAt(i - 1);
                        if (isAuthorChar(preMentionedChar)) {
                            continue;
                        }
                    }
                    startPos = i + 1;
                    int j = 1;
                    while (i + j < text.length() && isAuthorChar(text.charAt(i + j))) {
                        j+=1;
                    }
                    endPos = i + j;
                    mentionedUser.add(text.substring(startPos, endPos));
                    i = i + j;
                }
            }

        }
        return mentionedUser;

    }

}
