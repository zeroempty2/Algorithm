import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        pick = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            pick[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
