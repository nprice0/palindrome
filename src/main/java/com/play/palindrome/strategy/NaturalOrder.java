package com.play.palindrome.strategy;

import java.util.Comparator;

/**
 * Interface for palindrome strategies.  Uses defaults from {@link com.play.palindrome.strategy.PalindromeStrategy},
 * however -
 * <ul>
 * <li>provides a comparator using natural order only
 * </ul>
 */
public class NaturalOrder implements PalindromeStrategy {

    public Comparator<String> getComparator(){
        return  Comparator.naturalOrder();
    };

}
