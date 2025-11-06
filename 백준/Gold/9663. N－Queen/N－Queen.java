import java.io.*;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    static void backtrack(int row) {
        if (row == N) {   // N개의 퀸을 다 배치함
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + N - 1]) continue;

            col[c] = diag1[row + c] = diag2[row - c + N - 1] = true;

            backtrack(row + 1);

            col[c] = diag1[row + c] = diag2[row - c + N - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        backtrack(0);

        System.out.println(count);
    }
}
