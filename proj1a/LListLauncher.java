public class LListLauncher {
    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        boolean isEmpty = L.isEmpty();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        L.removeFirst();
        L.removeLast();
        /*L.addFirst(1991);
        L.addFirst(1992);
        L.addFirst(1993);
        L.addFirst(1994);
        L.addFirst(1995);
        L.addFirst(1996);
        L.addFirst(1997);
        L.addFirst(1998);
        L.addFirst(1999);
        L.addFirst(2000);
        L.addFirst(2001);
        L.addFirst(2002);
        L.addFirst(2003);*/
        isEmpty = L.isEmpty();
        int length = L.size();
        L.removeFirst();
        L.removeLast();
        length = L.size();
        L.get(3);
        int item1 = L.getRecursive(3);
        /*LinkedListDeque<Integer> K = new LinkedListDeque<>(L);
        System.out.println(K);*/

    }
}
