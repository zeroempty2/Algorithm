import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] rowGuard = new boolean[N];
        boolean[] colGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    rowGuard[i] = true;
                    colGuard[j] = true;
                }
            }
        }

        int emptyRow = 0;
        int emptyCol = 0;

        for (int i = 0; i < N; i++) {
            if (!rowGuard[i]) emptyRow++;
        }

        for (int j = 0; j < M; j++) {
            if (!colGuard[j]) emptyCol++;
        }

        System.out.println(Math.max(emptyRow, emptyCol));
    }
}
