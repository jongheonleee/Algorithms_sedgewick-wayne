package sort.original;

public abstract sealed class AbstractArraySort<T extends Comparable>
        permits SelectionSort, InsertionSort, ShellSort, MergeSortTopDown, MergeSortBottomUp, QuickSort {

    T[] arr;

    public AbstractArraySort(T[] arr) {
        this.arr = arr;
    }

    public abstract void sort();

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0; // v < w -> true else false
    }

    protected void exch(int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    protected void show() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++)
            sb.append(arr[i]).append(" -> ");

        System.out.println(sb.subSequence(0, sb.length() - 4));
    }

    protected boolean isSorted() {
        for (int i=1; i<arr.length; i++)
            if (less(arr[i], arr[i-1])) return false;

        return true;
    }
}
