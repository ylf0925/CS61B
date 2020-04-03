public class ArrayDeque<T> {

    /**
     * Instance variables
     */
    private int size;
    private int nextFstIdx;
    private int nextLstIdx;
    private T[] items;
    private static final int RESIZEFCT = 2;


    /**
     * Constructor
     */
    public ArrayDeque() {
        size = 0;
        nextFstIdx = 3;
        nextLstIdx = 4;
        items = (T[]) new Object[8];
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        items[nextFstIdx] = item;
        nextFstIdx = circularIdxMinus(nextFstIdx);
        size++;
        checkUsageRatio();
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addLast(T item) {
        items[nextLstIdx] = item;
        nextLstIdx = circularIdxPlus(nextLstIdx);
        size++;
        checkUsageRatio();
    }

    /**
     * check if deque is empty;
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * get deque size;
     */
    public int size() {
        return size;
    }

    /**
     * print the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        int countItem = 0;
        int currIdx = nextFstIdx + 1;
        while (countItem < size) {
            //currIdx = checkCurrIdx(currIdx, this.items.length);
            System.out.println(items[currIdx]);
            currIdx++;
            countItem++;
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size != 0) {
            nextFstIdx = circularIdxPlus(nextFstIdx);
            T curr = items[nextFstIdx];
            items[nextFstIdx] = null;
            size--;
            checkUsageRatio();
            return curr;
        }
        return null;
    }

    /**
     * instance method
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size != 0) {
            nextLstIdx = circularIdxMinus(nextLstIdx);
            T curr = items[nextLstIdx];
            items[nextLstIdx] = null;
            size--;
            checkUsageRatio();
            return curr;
        }
        return null;
    }

    /**
     * instance method
     * Get the item at given index.
     */
    public T get(int index) {
        if ((index > size) || this.isEmpty()) {
            return null;
        }
        return items[circularIdxPlus(nextFstIdx + index)];
    }


    /**
     * return circular moved Idx.
     */
    private int circularIdxMinus(int idx) {
        if (idx - 1 < 0) {
            idx = idx - 1 + items.length;
            return idx;
        }
        return idx - 1;
    }

    private int circularIdxPlus(int idx) {
        if (idx + 1 > items.length - 1) {
            idx = idx + 1 - items.length;
            return idx;
        }
        return idx + 1;
    }

    /**
     * check deque usage ratio.
     */
    private void checkUsageRatio() {
        double occupied = size;
        double totalLength = items.length;
        double usageRatio = occupied / totalLength;
        if (items.length >= 16) {
            if (usageRatio == 1.0) {
                this.enlarge();
            }
            if (usageRatio <= 0.25) {
                this.shrink();
            }
        } else if (items.length == 8) {
            if (usageRatio >= 1.0) {
                this.enlarge();
            }
        }
    }

    /**
    * enlarge deque when needed.
    * */
    private void enlarge() {
        T[] rawArycopy = (T[]) new Object[RESIZEFCT * items.length];
        int headIdx = circularIdxPlus(nextFstIdx); //head of old deque
        int copyCount = 0;
        int copyIdx = rawArycopy.length / 4;
        while (copyCount < size) {
            rawArycopy[copyIdx] = items[headIdx];
            copyIdx++;
            headIdx = circularIdxPlus(headIdx);
            copyCount++;
        }
        items = rawArycopy;
        nextFstIdx = rawArycopy.length / 4 - 1;
        nextLstIdx = rawArycopy.length - 1 - nextFstIdx;
    }

    /**
     * shrink deque when needed.
     * */
    private void shrink() {
        T[] rawArycopy = (T[]) new Object[items.length / RESIZEFCT];
        int headIdx = circularIdxPlus(nextFstIdx); //head of old deque
        int copyCount = 0;
        int copyIdx = 0;
        while (copyCount < size) {
            rawArycopy[copyIdx] = items[headIdx];
            copyIdx++;
            headIdx = circularIdxPlus(headIdx);
            copyCount++;
        }
        items = rawArycopy;
        nextFstIdx = rawArycopy.length - 1;
        nextLstIdx = size;
    }
}
