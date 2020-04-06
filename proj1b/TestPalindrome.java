import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("abababaaabaaabaaabababa"));
        assertFalse(palindrome.isPalindrome("AAa"));
        assertFalse(palindrome.isPalindrome("abca"));
        assertFalse(palindrome.isPalindrome("abca"));
        assertFalse(palindrome.isPalindrome("2babca"));
    }

    @Test
    public void testisPalindromeCC(){
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake",obo));
        assertTrue(palindrome.isPalindrome("acdb",obo));
        assertFalse(palindrome.isPalindrome("fafaf",obo));
    }

}