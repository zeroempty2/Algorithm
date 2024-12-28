import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] cost = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for(int i = 1; i <= n; i++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int d = 1; d <= n; d++){
            dp[d][0] =  Math.min(dp[d-1][1], dp[d-1][2]) + cost[d][0];
            dp[d][1] =  Math.min(dp[d-1][0], dp[d-1][2]) + cost[d][1];
            dp[d][2] =  Math.min(dp[d-1][1], dp[d-1][0]) + cost[d][2];
        }
       
        System.out.println(Math.min(dp[n][0],Math.min(dp[n][1], dp[n][2])));
        }

    }

