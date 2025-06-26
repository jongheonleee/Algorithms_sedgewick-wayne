package fundamental_concept.my_implements;

public class MyFixedCapacityStack<T> {
    private T[] arr;
    private int cap;
    private int N;

    public MyFixedCapacityStack(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException();
        }

        arr = (T[]) new Object[cap];
        this.cap = cap;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T e) {
        if (cap == N) {
            throw new IllegalStateException();
        }

        arr[N++] = e;
    }

    public T pop() {
        if (N == 0) {
            throw new IllegalStateException();
        }

        return arr[--N];
    }

}
