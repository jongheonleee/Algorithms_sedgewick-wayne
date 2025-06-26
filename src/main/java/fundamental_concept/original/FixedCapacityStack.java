package fundamental_concept.original;


/**
 * 문제 상황
 * - 1. 배열로 초기에 크기를 고정하면 비효율적인 측면이 발생한다
 *  - 현재 담겨진 원소의 개수와 상관없이 항상 그 크기를 유지해야함
 *  - 이는 부족할 때도 있고 불필요하게 많을 때도 있다
 *
 * - 2. 초기에 설계한 API에서 벗어난 기능을 지원해야 할 수도 있다
 *  - 사용자가 불필요한 부분까지 고려해야할 수 도 있음
 */

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;


    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}
