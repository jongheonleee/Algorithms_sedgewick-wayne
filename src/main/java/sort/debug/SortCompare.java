package sort.debug;

import sort.original.AbstractArraySort;
import sort.original.InsertionSort;
import sort.original.SelectionSort;
import sort.original.ShellSort;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class SortCompare {

    private static final List<AbstractArraySort> algs = new ArrayList<>();
    private static Double[] arr;
    private static String description1 = """
        ### given array
        > %s
        
        ### result 
        > %s => %.3f
        > %s => %.3f       
    """;


    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if (algs.size() == 0) throw new IllegalStateException();

        switch (alg) {
            case "Selection" -> algs.get(0).sort();
            case "Insertion" -> algs.get(1).sort();
            case "Shell" -> algs.get(2).sort();
            default -> throw new IllegalArgumentException("Unsupported algorithm: " + alg);
        }

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0;
        arr = new Double[N];

        for (int t=0; t<T; t++) {

            for (int i=0; i<N; i++)
                arr[i] = RandomGenerator.getDefault().nextDouble();

            initAlgs();
            total += time(alg, arr);
        }

        return total;
    }

    private static void initAlgs() {
        algs.clear();

        algs.add(new SelectionSort<>(arr.clone()));
        algs.add(new InsertionSort<>(arr.clone()));
        algs.add(new ShellSort(arr.clone()));
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];

        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        System.out.printf(description1, showArr(), alg1, t1, alg2, t2);
        System.out.printf("For %d random Dobules\n %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", (t2/t1), alg2);
    }

    private static String showArr() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Double a: arr) {
            sb.append(a).append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
