public class ArrayDeque<T> {

    /**
     * Instance variables
     */
    private int size;
    private int nextFstIdx;
    private int nextLstIdx;
    private T[] items;
    private double usageRatio;

    /**/

    /**
     * Constructor
     */
    public ArrayDeque() {
        this.size = 0;
        //Idx 0 is the first node to be operated
        nextFstIdx = 0;
        nextLstIdx = 1;
        items = (T[]) new Object[8];
        double occupied = size;
        double totalLength = items.length;
        usageRatio = occupied / totalLength;
    }

    /**
     * instance method
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        this.items[nextFstIdx] = item;
        nextFstIdx--;
        nextFstIdx = checkCurrIdx(nextFstIdx);
        size++;
    }

    /**
     * instance method
     * Adds an item of type T to the front of the deque.
     */
    public void addLast(T item) {
        this.items[nextLstIdx] = item;
        nextLstIdx++;
        nextLstIdx = checkCurrIdx(nextLstIdx);
        size++;
    }

    /**
     * instance method
     * check if deque is empty;
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * instance method
     * get deque size;
     */
    public int size() {
        return size;
    }

    /**
     * instance method
     * print the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        int countItem = 0;
        int currIdx = nextFstIdx + 1;
        while (countItem < size) {
            currIdx = checkCurrIdx(currIdx);
            System.out.println(items[currIdx]);
            currIdx++;
            countItem++;
        }
        System.out.println(" ");
    }


    /**
     * instance method
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        nextFstIdx++;
        nextFstIdx = checkCurrIdx(nextFstIdx);
        T curr = items[nextFstIdx];
        //To prevent loitering, null out deleted Items.
        items[nextFstIdx] = null;
        size--;
        this.checkSize();
        return curr;
    }

    /**
     * instance method
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        nextLstIdx--;
        nextLstIdx = checkCurrIdx(nextLstIdx);
        T curr = items[nextLstIdx];
        //To prevent loitering, null out deleted Items.
        items[nextLstIdx] = null;
        size--;
        this.checkSize();
        return curr;
    }


    /**
     * instance method
     * Get the item at given index.
     */
    public T get(int index) {
        if ((index > size) || this.isEmpty()) {
            return null;
        }
        int pos = nextFstIdx;
        pos++;
        pos = checkCurrIdx(pos);
        return items[pos + index - 1];
    }


    /**
     * function
     * check current    Idx. if out of bound, make it circular.
     */
    private int checkCurrIdx(int Idx) {
        if (Idx > items.length - 1) {
            Idx = Idx - items.length;
        }
        if (Idx < 0) {
            Idx = Idx + items.length;
        }
        return Idx;
    }

    /**
     * instance method
     * ensure deque has non-negative size.
     */
    private void checkSize() {
        if (this.size < 0) {
            this.size = 0;
        }
    }

    /**
     * instance method
     * check deque usage ratio.
     */
    private void checkUsageRatio() {
        if (this.usageRatio <= 0.25) {
            int startIdx, endIdx;
            startIdx = nextFstIdx;
            endIdx = nextLstIdx;
            startIdx++;
            startIdx = checkCurrIdx(startIdx);
            endIdx--;
            endIdx = checkCurrIdx(endIdx);
            T[] rawAryCopy = (T[]) new Object[this.items.length*2];
            System.arraycopy(items,startIdx,rawAryCopy,rawAryCopy, );
        }
        if (this.usageRatio >= 0.5) {
            T[] rawAryCopy = (T[]) new Object[this.items.length*2];
        }
    }


}
