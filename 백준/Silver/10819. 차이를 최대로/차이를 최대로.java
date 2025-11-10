import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] used;
    static int[] perm;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        used = new boolean[N];
        perm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.println(maxValue);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = arr[i];
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
}
