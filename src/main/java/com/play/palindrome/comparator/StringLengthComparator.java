package com.play.palindrome.comparator;

import java.util.Comparator;

/**
 * A comparator that compares according to string length
 *
 */
public enum StringLengthComparator implements Comparator<String> {
    INSTANCE;

    /**
     * Compares its two arguments for length.  Returns a negative integer,zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.<p>
     */
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}
