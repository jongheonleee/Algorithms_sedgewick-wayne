package fundamental_concept.original;

import java.util.List;


/**
 * 결국에는 서로 연결된 내용을 어떻게 빠르게 파악할 수 있냐가 문제의 핵심임
 *
 *  Union Find를 구현하는 3가지 방식이 있음
 *  밑에는 가장 초기 방식
 *  => 각 위치마다 고유의 id를 부여하고 서로 연결된 부분은 하나의 id로 만듦
 */
public class UF
{
    private int[] id;
    private int count;

    public UF(int N)
    {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++)
            id[i] = i;
    }

    public static void main(String[] args)
    {
        int N = 10;
        var uf = new UF(N);

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

            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }

        System.out.println(uf.count() + " components");
    }

    public int count()
    { return count; }

    public boolean connected(int p, int q)
    { return find(p) == find(q); }

    public int find(int p)
    { return id[p]; }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i=0; i<id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }
}
