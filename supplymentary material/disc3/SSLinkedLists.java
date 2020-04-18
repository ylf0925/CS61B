
public class SSLinkedLists {

    private static class IntNode {
        int item;
        IntNode next;

        IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

        static IntNode reverseHelper(IntNode head) {
            if (head.next == null) {
                return head;
            }
            IntNode tail = head.next;
            head.next = null;
            IntNode newHead = reverseHelper(tail);
            tail.next = head;
            return newHead;
        }
    }

    private int size;
    private IntNode first;

    public SSLinkedLists(int x) {
        first = new IntNode(x, null);
        size += 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public void insert(int item, int position) {
        IntNode p = first;
        if (position >= size) {
            while (p.next != null) {
                p = p.next;
            }
            p.next = new IntNode(item, null);
        } else {
            IntNode prev = new IntNode(-1, first);
            int currIdx = 0;
            while (position != currIdx) {
                currIdx++;
                p = p.next;
                prev = prev.next;
            }
            IntNode freshNode = new IntNode(item, p);
            prev.next = freshNode;
        }
    }

    /**
     * iteratively
     */

    /*public void reverse() {
        IntNode a = first;
        IntNode b = null;
        while(a.next != null) {
            a = a.next;
            first.next = b;
            b = first;
            first = a;
        }
        a.next = b;
    }*/


    /*
     * recursively
     * */
    public void reverse() {
        IntNode node = this.first;
        this.first = IntNode.reverseHelper(node);
    }
}
