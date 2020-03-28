
/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {
    private static class IntNode {
        int item;
        IntNode next;

        IntNode(int i, IntNode n) {
            item = i;
            next = n;
            //System.out.println(size);
        }
    }


    /**
     * The first item (if it exists) is at sentinel.next.
     */
    private IntNode sentinel;
    private int size;

    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = new IntNode(5, null);
    }

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**
     * guide4 B2
     * Second constructor
     */
    public SLList(int[] ary) {
        sentinel = new IntNode(-1, null);
        int aryLength = ary.length;
        sentinel.next = new IntNode(ary[0], null);
        IntNode node = sentinel.next;
        for (int i = 1; i < aryLength; i++) {
            node.next = new IntNode(ary[i], null);
            node = node.next;
        }
        size = aryLength;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * guide4 B1
     * Deletes the first element in SLList
     */
    public void deleteFirst() {
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    /**
     * guide4 C1
     */
    public void addAdjacent() {
        IntNode curr = sentinel.next;
        while (curr != null) {
            if (curr.next != null && curr.item == curr.next.item) {
                curr.item = curr.item + curr.item;
                curr.next = curr.next.next;
                size -= 1;
            } else {
                curr = curr.next;
            }
        }
    }

    /**
     * guide4 C2
     */
    public void addSquare(IntNode tail) {
        IntNode curr = sentinel.next;
        IntNode p = curr.next;
        while (curr != null) {
            if (p != null) {
                curr.next = new IntNode(curr.item * curr.item,p);
                curr = p;
                p = p.next;
                size += 1;
            } else {
                curr.next = new IntNode(curr.item * curr.item,tail);
                size += 2;
                break;
            }
        }
    }
    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        L.addLast(30);
        L.addLast(40);
        L.addLast(50);
        L.deleteFirst();
        int[] a = new int[]{1, 1, 2, 2, 4, 4, 8, 6, 4, 7};
        L = new SLList(a);
        L.addAdjacent();
        IntNode node = new IntNode(2077,null);
        L.addSquare(node);
        System.out.println(L.size());
    }
}