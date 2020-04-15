package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;



    private int circularPlus(int idx) {
        if (idx + 1 > rb.length - 1) {
            idx = idx + 1 - rb.length;
            return idx;
        }
        return idx + 1;
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {

        if (fillCount == rb.length) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        rb[last] = x;
        last = circularPlus(last);
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {

        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T curr = rb[first];
        rb[first] = null;
        first = circularPlus(first);
        fillCount--;
        return curr;
    }


    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {

        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }


    /*
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        if (this.fillCount != other.fillCount) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = other.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (thisIterator.next() != otherIterator.next()) {
                return false;
            }
        }
        return true;
    }*/

    @Override
    public Iterator<T> iterator() {
        return new AryBufferIterator();
    }


    private class AryBufferIterator implements Iterator<T> {
        private int currPos;
        private int currCount;

        AryBufferIterator() {
            currPos = first;
            currCount = 0;
        }

        @Override
        public boolean hasNext() {
            return currCount < fillCount;
        }

        @Override
        public T next() {
            T returnItem = rb[currPos];
            currPos = circularPlus(currPos);
            currCount += 1;
            return returnItem;
        }
    }
}


