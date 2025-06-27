package sort;

public final class InsertionSort<T extends Comparable> extends AbstractArraySort {

    public InsertionSort(T[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
        Integer[] dummy = {1, 3, 5, 6, 7, 2};
        var is = new InsertionSort<>(dummy);
        is.sort();
        assert is.isSorted();
        is.show();
    }

    @Override
    public void sort() {
        for (int i=1; i<arr.length; i++) {
            for (int j=i; j>0 && less(arr[j], arr[j-1]); j--)
                exch(j, j-1);
        }
    }
}
