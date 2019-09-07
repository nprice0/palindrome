package com.play.palindrome.strategy;

import com.play.palindrome.comparator.StringLengthComparator;
import java.util.Comparator;

/**
 * Interface for palindrome strategies.  Defaults are defined, where it considers only :
 * <ul>
 * <li>alpha characters
 * <li>delimits word by spaces
 * <li>a minimum length of 2 characters
 * <li>ignores letter case within palindrome words
 * <li>has a comparator for string length, then natural order
 * </ul>
 */
public interface PalindromeStrategy {

    default Comparator<String> getComparator(){
        return StringLengthComparator.INSTANCE.thenComparing(Comparator.<String>naturalOrder());
    };

    default String getAllowedChars(){
        return "[^a-zA-Z ]";
    };

    default String getDelimiter(){
        return "[ ]";
    };

    default int getMinimumLength(){
        return 2;
    };

    default boolean isCaseSensitive(){
        return false;
    }

}
