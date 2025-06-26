package basic_data_structure.my_implements;

import java.util.Iterator;
import java.util.List;

/**
 * LIFO
 * - push() -> O(1)
 * - pop() -> O(1)
 * - isEmpty()
 * - size()
 */
public class MyStackByList<T> implements Iterable<T> {

    private Node first;
    private int N;

    public MyStackByList() {
        first = null;
        N = 0;
    }

    public static void main(String[] args) {
        var st = new MyStackByList<String>();

        List<String> dummy = List.of(
                "banana", "apple",
                "grape" , "mango",
                "cookie", "cat"
        );

        for (String item: dummy) {
            st.push(item);
        }

        // expected result: cat -> cookie -> mango -> grape -> apple -> banana
        for (String item: st) {
            System.out.printf("item : %s \n", item);
        }

        System.out.printf("size : %d\n", st.size());
        System.out.printf("isEmpty : %b\n", st.isEmpty());

    }

    public void push(T item) {
        if (isEmpty()) {
            first = new Node(item, null);
        } else {
            Node oldNode = first;
            first = new Node(item, oldNode);
        }
        N++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        Node oldNode = first;
        first = first.next;
        N--;
        return oldNode.item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseItems();
    }

    private class Node {
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class ReverseItems implements Iterator {

        private int k;

        private ReverseItems() {
            k = N;
        }

        @Override
        public boolean hasNext() {
            return k > 0;
        }

        @Override
        public T next() {
            T item = pop();
            k--;
            return item;
        }
    }

}
