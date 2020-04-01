public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> L = new ArrayDeque<>();
        String curr = " ";
        boolean isEmp = L.isEmpty();
        int length = L.size();
        L.addFirst("1991");
        L.addFirst("1992");
        L.addFirst("1993");
        L.addLast("2020");
        L.addLast("2019");
        L.addLast("2018");
        L.addLast("2040");
        L.addLast("2048");
        isEmp = L.isEmpty();
        length = L.size();
        L.printDeque();
        curr = L.removeFirst();
        curr = L.removeFirst();
        curr = L.removeLast();
        curr = L.removeLast();
        curr = L.get(2);
    }
}
