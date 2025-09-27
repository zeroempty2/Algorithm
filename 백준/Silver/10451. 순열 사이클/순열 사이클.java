import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] perm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            perm = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                perm[i] = sc.nextInt();
            }

            int cycles = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cycles++;
                }
            }
            System.out.println(cycles);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        int next = perm[start];
        if (!visited[next]) {
            dfs(next);
        }
    }
}
