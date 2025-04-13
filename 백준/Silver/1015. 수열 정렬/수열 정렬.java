import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value == other.value) return this.index - other.index;
            return this.value - other.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[] A = new int[n];
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input[i]);
            pairs[i] = new Pair(A[i], i);
        }

        Arrays.sort(pairs);

        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            P[pairs[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb);
    }
}
