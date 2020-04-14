package es.datastructur.synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.dequeue();
        arb.dequeue();
        int expected = 3;
        int actual = arb.peek();
        assertEquals(expected, actual);
        arb.dequeue();
        arb.dequeue();
        assertTrue(arb.isEmpty());
        arb.enqueue(5);
        arb.enqueue(6);
        assertFalse(arb.isFull());
        arb.enqueue(7);
        arb.enqueue(8);
        arb.enqueue(9);
        arb.enqueue(10);
        arb.enqueue(11);
        arb.enqueue(12);
        arb.enqueue(13);
        arb.enqueue(14);
        assertTrue(arb.isFull());
        //fully loaded
    }
}
