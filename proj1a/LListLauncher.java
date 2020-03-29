public class LListLauncher {
    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        boolean isEmpty = L.isEmpty();
        L.addLast(0);
        L.addLast(1);
        L.removeFirst();
        L.addLast(3);
        L.addLast(4);
        L.addFirst(5 );
        int i = L.get(3);
        int j = L.getRecursive(3);
        LinkedListDeque<Integer> K = new LinkedListDeque<>(L);
        System.out.println(K);

    }
}
