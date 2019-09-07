package com.play;


import com.play.palindrome.Palindrome;
import com.play.palindrome.strategy.CaseSensitive;
import com.play.palindrome.strategy.PipeDelimiter;
import com.play.palindrome.strategy.NaturalOrder;
import com.play.palindrome.strategy.SingleCharacter;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PalindromeTest {


    @Test
    public void defaultStrategyTest() {
        String simple = "a \"fast\" racecar is being delivered to a Madam Sallas!";

        Palindrome palindrome = new Palindrome();
        List<String> palindroneList = palindrome.getPalindrome(simple);

        assertEquals(3, palindroneList.size());
        assertThat(palindroneList, contains("Madam", "Sallas", "racecar"));
    }


    @Test
    public void defaultStrategyAllDelimiterStringTest() {
        String simple = "                   ";

        Palindrome palindrome = new Palindrome();
        List<String> palindroneList = palindrome.getPalindrome(simple);

        assertEquals(0, palindroneList.size());
        assertTrue(palindroneList.isEmpty());
    }


    @Test
    public void defaultStrategyEmptyStringTest() {
        String simple = "";

        Palindrome palindrome = new Palindrome();
        List<String> palindroneList = palindrome.getPalindrome(simple);

        assertEquals(0, palindroneList.size());
        assertTrue(palindroneList.isEmpty());
    }


    @Test
    public void caseSensitiveStrategyTest() {
        String multicase = "the RacecaR is being delivered to a madam Sallas";

        Palindrome palindrome = new Palindrome(new CaseSensitive());
        List<String> palindroneList = palindrome.getPalindrome(multicase);

        assertEquals(2, palindroneList.size());
        assertThat(palindroneList, contains("madam", "RacecaR"));
    }


    @Test
    public void naturalOrderStrategyTest() {
        String natural = "The Racecar is being delivered to a Madam Sallas. The car was a Honda Civic racecar.";

        Palindrome palindrome = new Palindrome(new NaturalOrder());
        List<String> palindroneList = palindrome.getPalindrome(natural);

        assertEquals(5, palindroneList.size());
        assertThat(palindroneList, contains("Civic", "Madam", "Racecar", "Sallas", "racecar"));
    }


    @Test
    public void defaultOrderPipeDelimiterTest() {
        String pipeDelimiter = "where in this world?|Never Odd Or Even|madam salas had a walk!";

        Palindrome palindrome = new Palindrome(new PipeDelimiter());
        List<String> palindroneList = palindrome.getPalindrome(pipeDelimiter);

        assertEquals(1, palindroneList.size());
        assertThat(palindroneList, contains("NeverOddOrEven"));
    }


    @Test
    public void singleCharacterPalindroneTest() {
        String singleCharacter = "a racecar is being delivered to a madam sallas, lucky lady!!";

        Palindrome palindrome = new Palindrome(new SingleCharacter());
        List<String> palindroneList = palindrome.getPalindrome(singleCharacter);

        assertEquals(5, palindroneList.size());
        assertThat(palindroneList, contains("a", "a", "madam", "sallas", "racecar"));
    }
}
