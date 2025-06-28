package sort.original;

import java.util.Arrays;

public final class QuickSort<T extends Comparable> extends AbstractArraySort {

    public QuickSort(T[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        Arrays.sort(arr);
        sort(0, arr.length - 1);
    }

    private void sort(int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(lo, hi);
        sort(lo, j-1);
        sort(j+1, hi);
    }

    private int partition(int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = arr[lo]; // 분할 기준 항목

        while (true) {
            // 좌우측을 각각 스캔하면서 완료 여부를 확인하고 교환함
            while (less(arr[++i], v)) if (i == hi) break;
            while (less(v, arr[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(i, j);
        }

        exch(lo, j); // 분할 기준 항목 v를 a[j]에 넣음
        return j;    // a[lo..j-1] <= arr[j] <= arr[j+1..hi] 관계를 만족
    }

}
