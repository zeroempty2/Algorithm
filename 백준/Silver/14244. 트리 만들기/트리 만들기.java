import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= m; i++) {
            sb.append(0).append(" ").append(i).append("\n");
        }

        for (int i = m + 1; i < n; i++) {
            sb.append(i - 1).append(" ").append(i).append("\n");
        }

        System.out.print(sb);
    }
}
