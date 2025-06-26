package fundamental_concept.my_implements;

import fundamental_concept.original.UF;

import java.util.List;

/**
 * - union(p, q)
 * - find(p)
 * - connected(p, q)
 * - count()
 */
public class MyUF {

    private int[] a;
    private int count;

    public static void main(String[] args) {
        int N = 10;
        var myUF = new MyUF(N);

        List<List<Integer>> pairs = List.of(
                List.of(4, 3),
                List.of(3, 8),
                List.of(6, 5),
                List.of(9, 4),
                List.of(2, 1),
                List.of(5, 0),
                List.of(7, 2),
                List.of(6, 1)
        );

        for (List<Integer> pair : pairs) {
            int p = pair.get(0);
            int q = pair.get(1);

            if (myUF.connected(p, q)) continue;
            myUF.union(p, q);
            System.out.println(p + " " + q);
        }

        System.out.println(myUF.count() + " components");
    }


    public MyUF(int N) {
        a = new int[N];
        count = N;

        for (int i=0; i<N; i++) {
            a[i] = i;
        }
    }

    public void union(int p, int q) {
        int pID = a[p];
        int qID = a[q];

        if (pID == qID) return;

        for (int i=0; i<a.length; i++) {
            if (pID == a[i]) a[i] = qID;
        }

        count--;
    }

    public int find(int p) {
        return a[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
