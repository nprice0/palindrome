package com.play.palindrome.strategy;

/**
 * Interface for palindrome strategies.  Uses defaults from {@link com.play.palindrome.strategy.PalindromeStrategy},
 * however -
 * <ul>
 * <li>uses a '|' delimiter for words
 * </ul>
 */
public class PipeDelimiter implements PalindromeStrategy {

    @Override
    public String getAllowedChars(){
        return "[^a-zA-Z|]";
    };

    @Override
    public String getDelimiter(){
        return "[|]";
    };

}
