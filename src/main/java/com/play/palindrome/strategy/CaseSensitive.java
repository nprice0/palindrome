package com.play.palindrome.strategy;

/**
 * Interface for palindrome strategies.  Uses defaults from {@link com.play.palindrome.strategy.PalindromeStrategy},
 * however -
 * <ul>
  * <li>considers letter case for palindrome words
 * </ul>
 */
public class CaseSensitive implements PalindromeStrategy {

    @Override
    public boolean isCaseSensitive(){
        return true;
    }
}
