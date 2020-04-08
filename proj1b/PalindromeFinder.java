
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        //Set character comparator to offbyone
        OffByOne byOne = new OffByOne();
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, byOne)) {
                System.out.println(word);
            }
        }
    }
}
