public class ArrayDeque<T> {

    /**
     * Instance variables
     */
    private int size;
    private int nextFstIdx;
    private int nextLstIdx;
    private T[] items;

    /**
     * Constructor
     */
    public ArrayDeque() {
        this.size = 0;
        //Idx 0 is the first node to be operated
        nextFstIdx = 3;
        nextLstIdx = 4;
        items = (T[]) new Object[8];
    }

    /**
     * instance method
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        if (size == 0) {
            this.nextFstIdx = 3;
            this.nextLstIdx = 4;
        }
        this.items[nextFstIdx] = item;
        size++;
        this.checkUsageRatio();
        nextFstIdx--;
        nextFstIdx = checkCurrIdx(nextFstIdx, this.items.length);
    }

    /**
     * instance method
     * Adds an item of type T to the front of the deque.
     */
    public void addLast(T item) {
        if (size == 0) {
            this.nextFstIdx = 3;
            this.nextLstIdx = 4;
        }
        this.items[nextLstIdx] = item;
        size++;
        this.checkUsageRatio();
        nextLstIdx++;
        nextLstIdx = checkCurrIdx(nextLstIdx, this.items.length);
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
            //currIdx = checkCurrIdx(currIdx, this.items.length);
            System.out.println(items[currIdx]);
            currIdx++;
            countItem++;
        }
    }

    /**
     * instance method
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size != 0) {
            nextFstIdx++;
            nextFstIdx = checkCurrIdx(nextFstIdx, this.items.length);
            T curr = items[nextFstIdx];
            //To prevent loitering, null out deleted Items.
            items[nextFstIdx] = null;
            size--;
            this.checkUsageRatio();
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
            nextLstIdx--;
            nextLstIdx = checkCurrIdx(nextLstIdx, this.items.length);
            T curr = items[nextLstIdx];
            //To prevent loitering, null out deleted Items.
            items[nextLstIdx] = null;
            size--;
            this.checkUsageRatio();
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
        int pos = nextFstIdx;
        pos++;
        pos = checkCurrIdx(pos, this.items.length);
        return items[pos + index];
    }

    /**
     * function
     * check current Idx. if out of bound, make it circular.
     */
    private int checkCurrIdx(int Idx, int currRawLength) {
        if (Idx > currRawLength - 1) {
            Idx = Idx - currRawLength;
        }
        if (Idx < 0) {
            Idx = Idx + currRawLength;
        }
        return Idx;
    }

    /**
     * instance method
     * check deque usage ratio.
     */
    private void checkUsageRatio() {
        double occupied = size;
        double totalLength = items.length;
        double usageRatio = occupied / totalLength;
        if (items.length >= 16) {
            if (usageRatio >= 0.5 || usageRatio <= 0.25) {
                this.resizing(usageRatio);
            }
        } else if (items.length == 8) {
            if (usageRatio >= 0.5) {
                this.resizing(usageRatio);
            }
        }
    }

    /**
     * instance method
     * resizing, if needed.
     */
    private void resizing(double usageRatio) {
        T[] rawAryCopy = (T[]) new Object[0];
        int leftMovingIdx;
        int rightMovingIdx;
        int prevleftMovingIdx;
        int prevrightMovingIdx;
        int loopcount = 0;
        boolean needEnlarge = false;
        boolean needShrink = false;
        int newNextFstIdx = 0;
        int newNextLstIdx = 0;

        if (usageRatio >= 0.5) {
            rawAryCopy = (T[]) new Object[this.items.length * 2];
            needEnlarge = true;
        } else if (usageRatio <= 0.25) {
            rawAryCopy = (T[]) new Object[this.items.length / 2];
            needShrink = true;
        }
        if (needEnlarge) {
            prevleftMovingIdx = this.items.length / 2 - 1;
            prevrightMovingIdx = prevleftMovingIdx + 1;
            leftMovingIdx = rawAryCopy.length / 2 - 1;
            rightMovingIdx = leftMovingIdx + 1;
            while (loopcount < this.size) {
                rawAryCopy[leftMovingIdx] = items[prevleftMovingIdx];
                rawAryCopy[rightMovingIdx] = items[prevrightMovingIdx];
                if (prevleftMovingIdx == 0 || prevrightMovingIdx == items.length - 1) {
                    break;
                }
                leftMovingIdx--;
                prevleftMovingIdx--;
                rightMovingIdx++;
                prevrightMovingIdx++;
                loopcount++;
            }
            int rightDelta = this.nextLstIdx - this.items.length / 2;
            int leftDelta = this.items.length / 2 - 1 - this.nextFstIdx;
            this.nextLstIdx = rightDelta + rawAryCopy.length / 2;
            this.nextFstIdx = rawAryCopy.length / 2 - 1 - leftDelta;
        }

        if (needShrink) {
            int symmetry = (this.nextLstIdx + this.nextFstIdx) / 2;
            leftMovingIdx = rawAryCopy.length / 2 - 1;
            rightMovingIdx = leftMovingIdx + 1;
            prevleftMovingIdx = symmetry;
            prevrightMovingIdx = symmetry + 1;
            while (loopcount < this.size) {
                rawAryCopy[leftMovingIdx] = items[prevleftMovingIdx];
                rawAryCopy[rightMovingIdx] = items[prevrightMovingIdx];
                if (rawAryCopy[leftMovingIdx] != null) {
                    newNextFstIdx = leftMovingIdx;
                }
                if (rawAryCopy[rightMovingIdx] != null) {
                    newNextLstIdx = rightMovingIdx;
                }
                if (leftMovingIdx == 0 || rightMovingIdx == rawAryCopy.length - 1) {
                    break;
                }
                leftMovingIdx--;
                rightMovingIdx++;
                prevleftMovingIdx--;
                prevrightMovingIdx++;
                loopcount++;
            }
            this.nextLstIdx = newNextLstIdx + 1;
            this.nextFstIdx = newNextFstIdx - 1;
        }
        this.items = rawAryCopy;
    }
}
