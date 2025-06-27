package sort;

public final class SelectionSort<T extends Comparable> extends AbstractArraySort {

    public SelectionSort(T[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
        Integer[] dummy = {1, 3, 5, 6, 7, 2};
        var ss = new SelectionSort<>(dummy);
        ss.sort();
        assert ss.isSorted();
        ss.show();
    }

    @Override
    public void sort() {
        for (int i=0; i<arr.length; i++) {
            int min = i;

            for (int j=i+1; j<arr.length; j++)
                if (less(arr[j], arr[min]))
                    min = j;

            exch(i, min);
        }
    }
}
