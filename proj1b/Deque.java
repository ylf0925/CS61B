public interface Deque<T> {
    //interface inheritance
    void addFirst(T item);
    void addLast(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
    //implementation inheritance
    default boolean isEmpty() {
        return size() == 0;
    }
}
