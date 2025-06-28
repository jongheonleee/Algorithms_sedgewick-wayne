package sort.original;

public final class MergeSortBottomUp<T extends Comparable> extends AbstractArraySort {

    private T[] aux;

    public MergeSortBottomUp(T[] arr) {
        super(arr);
        copy();
    }

    public static void main(String[] args) {
        Integer[] dummy = {1, 3, 5, 6, 7, 2};
        var ms = new MergeSortBottomUp<>(dummy);
        ms.sort();
        assert ms.isSorted();
        ms.show();
    }

    @Override
    public void sort() {
        aux = (T[]) new Comparable[arr.length];

        for (int sz=1; sz<arr.length; sz = sz + sz)             // sz: 부분 배열 크기
            for (int lo=0; lo< arr.length-sz; lo += sz + sz)    // lo: 부분 배열 인덱스
                merge(lo, lo+sz-1, Math.min(lo+sz+sz-1, arr.length-1));

    }

    private void merge(int lo, int mid, int hi) {
        // arr[lo..mid]와 arr[mid+1..hi] 병합
        int i = lo, j = mid + 1;

        copy(); // 복제

        for (int k=lo; k<=hi; k++) { // 다시 arr[lo..hi]으로 병합
            if      (i > mid)               arr[k] = aux[j++];
            else if (j > hi)                arr[k] = aux[i++];
            else if (less(aux[j], aux[i]))  arr[k] = aux[j++];
            else                            arr[k] = aux[i++];
        }
    }

    private void copy() {
        aux = (T[]) new Comparable[arr.length];

        for (int i=0; i<arr.length; i++)
            aux[i] = (T) arr[i];
    }
}
