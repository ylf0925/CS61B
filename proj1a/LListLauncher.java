public class LListLauncher {
    public static  void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<String>();
        boolean isEmpty = L.isEmpty();
        L.addFirst("Hello");
        L.addFirst("World");
        L.addFirst("I");
        L.addFirst("love");
        L.addFirst("you");
        L.addFirst("do");
        L.addFirst("you");
        L.addFirst("love");
        L.addFirst("me");
        L.addFirst("don't");
        L.addFirst("be");
        L.addFirst("shy");
        isEmpty = L.isEmpty();
        int length = L.size();
        L.removeFirst();
        L.removeLast();
        length = L.size();
        String item = L.get(3);
        System.out.println(item);
    }
}
