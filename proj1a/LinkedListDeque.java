public class LinkedListDeque<T> {

    /**
     * Sort of "Naked data structure"
     */
    private class TNode {
        private TNode prev;
        private TNode next;
        private T item;

        TNode(TNode p, T content, TNode n) {
            prev = p;
            item = content;
            next = n;
        }
    }

    private TNode sentinel;
    private int length;

    /**
     * Start from a circular sentinel TNode, both prev and next point to itself.
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        length = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */

    public void addFirst(T it) {
        TNode freshTNode = new TNode(null,it,null);
        TNode p = sentinel.next;
        sentinel.next = freshTNode;
        freshTNode.prev = sentinel;
        freshTNode.next = p;
        p.prev = freshTNode;
        length += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T it) {
        TNode freshTNode = new TNode(null,it,null);
        TNode p = sentinel.prev;
        sentinel.prev = freshTNode;
        freshTNode.next = sentinel;
        freshTNode.prev = p;
        p.next = freshTNode;
        length += 1;
    }

    /**
     * To determine the deque is empty or not.
     */
    public boolean isEmpty() {
        return ((sentinel.next == sentinel) && (sentinel.prev == sentinel));
    }

    /**
     * return the size of deque.
     */
    public int size() {
        return length;
    }

    /*
     * print the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     * */
    public void printDeque() {
        TNode curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println(" ");
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (sentinel.next != null) {
            TNode p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            p.next = null;
            p.prev = null;
            length -= 1;
            return p.item;
        } else {
            return null;
        }
    }


    /*
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * */
    public T removeLast() {
        if (sentinel.prev != null) {
            TNode p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.prev = sentinel;
            p.prev = null;
            p.next = null;
            length -= 1;
            return p.item;
        } else {
            return null;
        }
    }

    /**
     * Get the item at given index
     */
    public T get(int index) {
        if ((sentinel.next == sentinel) && (sentinel.prev == sentinel)) {
            return null;
        }
        //searching
        int forwardIdx = 0;
        int backwardIdx = length - 1;
        TNode forwardPivot = sentinel.next;
        TNode backwardPivot = sentinel.prev;
        while ((forwardIdx != index) && (backwardIdx != index)) {
            forwardPivot = forwardPivot.next;
            backwardPivot = backwardPivot.prev;
            forwardIdx++;
            backwardIdx--;
        }
        return forwardIdx == index ? forwardPivot.item : backwardPivot.item;
    }
}
