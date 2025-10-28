import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, new int[6]);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int depth, int start, int[] picked) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            picked[depth] = S[i];
            dfs(depth + 1, i + 1, picked);
        }
    }
}
