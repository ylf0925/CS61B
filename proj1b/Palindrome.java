public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deq = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deq.addLast(word.charAt(i));
        }
        return deq;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1){
            return true;
        }
        //deque size >=2
        while (d.size()>1) {
            if (d.removeLast() != d.removeFirst()){
                return false;
            }
        }
        return true;
    }
}
