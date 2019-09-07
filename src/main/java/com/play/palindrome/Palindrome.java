package com.play.palindrome;

import com.play.palindrome.strategy.PalindromeStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A palindrome is a word that reads the same backwards as forwards
 */
public class Palindrome {

    private PalindromeStrategy palindromeStrategy;


    public Palindrome() {
        palindromeStrategy = new PalindromeStrategy(){
        };
    }

    public Palindrome(PalindromeStrategy palindromeStrategy) {
        this.palindromeStrategy = palindromeStrategy;
    }


    /**
     * Returns a list from a given text of all the palindromes from the text
     *
     * @param text
     * @return
     */
    public List<String> getPalindrome(String text) {
        String[] words = text.replaceAll(palindromeStrategy.getAllowedChars(), "").split(palindromeStrategy.getDelimiter());
        List<String> palindromeList = new ArrayList<>();

        for (String word : words) {
            if (word.length() >= palindromeStrategy.getMinimumLength() && isPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        Collections.sort(palindromeList, palindromeStrategy.getComparator());
        return palindromeList;
    }


    public boolean isPalindrome(String text, String allowedCharacters) {
        return isPalindrome(text.replaceAll(allowedCharacters, ""));
    }


    /**
     * Checks if the word arg is a palindrome
     *
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        int startPosition = 0;
        int endPosition = word.length() - 1;
        while (endPosition > startPosition) {
            char startPositionChar = word.charAt(startPosition++);
            char endPositionChar = word.charAt(endPosition--);

            if (!palindromeStrategy.isCaseSensitive()) {
                if (Character.toLowerCase(startPositionChar) != Character.toLowerCase(endPositionChar))
                    return false;
            } else {
                if (startPositionChar != endPositionChar)
                    return false;
            }
        }
        return true;
    }

}