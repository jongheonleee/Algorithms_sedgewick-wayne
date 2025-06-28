package sort.original;

// 셀 정렬은 삽입 정렬의 확장 버전으로 서로 멀리 떨어진 항목 간에도
// 교환이 일어날 수 있게 함으로써 삽입 정렬이 빠르게 처리할 수 있는
// 부분적으로 정렬된 배열을 만듦
public final class ShellSort<T extends Comparable> extends AbstractArraySort {

    public ShellSort(T[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
        Integer[] dummy = {1, 3, 5, 6, 7, 2};
        var sh = new ShellSort<>(dummy);
        sh.sort();
        assert sh.isSorted();
        sh.show();
    }

    @Override
    public void sort() {
        int h = 1;

        while (h < arr.length / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i=h; i<arr.length; i++) {
                for (int j=i; j >= h && less(arr[j], arr[j-h]); j -=h)
                    exch(j, j-h);
            }

            h = h / 3;
        }
    }
}

