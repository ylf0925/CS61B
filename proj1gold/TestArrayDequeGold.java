import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStuAryDeque() {

        /**
         * @Source StudentArrayDequeLanuncher.java
         * */
        StudentArrayDeque<Integer> testArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctArrayDeque = new ArrayDequeSolution<>();

        //random call to addFirst / addLast
        for (int i = 0; i < 200; i += 1) {
            double decider = StdRandom.uniform();
            int randomNum = StdRandom.uniform(100000);
            if (decider < 0.5) {
                testArrayDeque.addLast(randomNum);
                correctArrayDeque.addLast(randomNum);
            } else {
                testArrayDeque.addFirst(randomNum);
                correctArrayDeque.addFirst(randomNum);
            }
        }

        //validation
        for (int i = 0; i < 200; i += 1) {
            Integer actual = testArrayDeque.get(i);
            Integer expected = correctArrayDeque.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                    + " not equal to " + expected + "!", actual, expected);
        }
        //if passed, continue testing

        //random call removeFst / removeLst and validate each
        for (int i = 0; i < 200; i += 1) {
            double decider = StdRandom.uniform();
            if (decider < 0.5) {
                Integer actual = testArrayDeque.removeFirst();
                Integer expected = correctArrayDeque.removeFirst();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                     + " not equal to " + expected + "!", actual, expected);
            } else {
                Integer actual = testArrayDeque.removeLast();
                Integer expected = correctArrayDeque.removeLast();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                     + " not equal to " + expected + "!", actual, expected);
            }
        }

    }
}
