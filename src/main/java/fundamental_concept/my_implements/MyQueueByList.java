package fundamental_concept.my_implements;

import java.util.Iterator;
import java.util.List;

/**
 * FIFO
 * - enqueue(): O(1)
 * - dequeue(): O(1)
 * - isEmpty()
 * - size()
 */
public class MyQueueByList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int N;

    public MyQueueByList() {
        first = null;
        last = null;
        N = 0;
    }

    public static void main(String[] args) {
        var q = new MyQueueByList<String>();

        List<String> dummy = List.of(
                "banana", "apple",
                "grape" , "mango",
                "cookie", "cat"
        );

        for (String item : dummy) {
            q.enqueue(item);
        }

        // expected result: banana -> apple -> grape -> mango -> cookie -> cat
        for (String item : q) {
            System.out.printf("item : %s \n", item);
        }

        System.out.printf("size : %d\n", q.size());
        System.out.printf("isEmpty : %b\n", q.isEmpty());
    }

    public void enqueue(T item) {
        if (isEmpty()) {
            Node newNode = new Node(item, null);
            first = newNode;
            last = newNode;
        } else {
            Node oldNode = last;
            Node newNode = new Node(item, null);
            oldNode.next = newNode;
            last = newNode;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        Node oldNode = first;
        first = first.next;
        oldNode.next = null;
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
    public Iterator iterator() {
        return new OrderItems();
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

    private class OrderItems implements Iterator {

        private int k;

        private OrderItems() {
            k = N;
        }

        @Override
        public boolean hasNext() {
            return k > 0;
        }

        @Override
        public T next() {
            T item = dequeue();
            k--;
            return item;
        }
    }
}
