package com.play.palindrome.strategy;

public class SingleCharacter implements PalindromeStrategy {

    /**
     * Interface for palindrome strategies.  Uses defaults from {@link com.play.palindrome.strategy.PalindromeStrategy},
     * however -
     * <ul>
     * <li>considers single letter words as a palindrome
     * </ul>
     */
    public int getMinimumLength() {
        return 1;
    };
}
