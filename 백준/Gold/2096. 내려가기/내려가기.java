import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[N+1][4];
        int[][] min = new int[N+1][4];
        int[][] max = new int[N+1][4];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j <= 3; j++) {
            max[1][j] = dp[1][j];
            min[1][j] = dp[1][j];
        }


        for (int d = 2; d <= N; d++) {
            max[d][1] = dp[d][1] + Math.max(max[d-1][1], max[d-1][2]);
            max[d][2] = dp[d][2] + Math.max(Math.max(max[d-1][1], max[d-1][2]), max[d-1][3]);
            max[d][3] = dp[d][3] + Math.max(max[d-1][2], max[d-1][3]);

            min[d][1] = dp[d][1] + Math.min(min[d-1][1], min[d-1][2]);
            min[d][2] = dp[d][2] + Math.min(Math.min(min[d-1][1], min[d-1][2]), min[d-1][3]);
            min[d][3] = dp[d][3] + Math.min(min[d-1][2], min[d-1][3]);
        }


        int maxValue = Math.max(Math.max(max[N][1], max[N][2]), max[N][3]);
        int minValue = Math.min(Math.min(min[N][1], min[N][2]), min[N][3]);

        System.out.println(maxValue + " " + minValue);
    }
}
