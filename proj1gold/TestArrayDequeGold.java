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
        StringBuilder errorMsg = new StringBuilder("");

        //random call to addFirst / addLast
        for (int i = 0; i < 200; i += 1) {
            double decider = StdRandom.uniform();
            int randomNum = StdRandom.uniform(100000);
            if (decider < 0.5) {
                testArrayDeque.addLast(randomNum);
                correctArrayDeque.addLast(randomNum);
                errorMsg.append("addLast(").append(randomNum).append(")").append("\n");
                Integer testCurr = testArrayDeque.get(i);
                Integer correctCurr = correctArrayDeque.get(i);
                assertEquals(errorMsg.toString(),testCurr,correctCurr);
            } else {
                testArrayDeque.addFirst(randomNum);
                correctArrayDeque.addFirst(randomNum);
                errorMsg.append("addFirst(").append(randomNum).append(")").append("\n");
                Integer testCurr = testArrayDeque.get(i);
                Integer correctCurr = correctArrayDeque.get(i);
                assertEquals(errorMsg.toString(),testCurr,correctCurr);
            }
        }


        //random call removeFst / removeLst
        for (int i = 0; i < 200; i += 1) {
            double decider = StdRandom.uniform();
            if (decider < 0.5) {
                Integer actual = testArrayDeque.removeFirst();
                Integer expected = correctArrayDeque.removeFirst();
                errorMsg.append("removeFirst()").append("\n");
                assertEquals(errorMsg.toString(),actual,expected);
            } else {
                Integer actual = testArrayDeque.removeLast();
                Integer expected = correctArrayDeque.removeLast();
                errorMsg.append("removeLast()").append("\n");
                assertEquals(errorMsg.toString(),actual,expected);
            }
        }

    }
}
