public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Number> L = new ArrayDeque<>();
        Number curr = 0;
        boolean isEmp = L.isEmpty();
        int length = L.size();
        L.addFirst(8);
        L.printDeque();
        new ArrayDeque(L);
    }
}

