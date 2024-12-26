import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] dp = new int[n+1][n+1];

        for(int d = 1; d < n + 1; d++){
            String[] arr = bf.readLine().split(" ");
            for(int p = 0; p < arr.length; p++){
                int num = Integer.parseInt(arr[p]);
                dp[d][p + 1] = num;
            }
        }

        for(int i = n; i >= 1; i--){
            int[] nums = dp[i];
            for(int j = 1; j < nums.length - 1; j++){
                dp[i - 1][j] = Math.max(dp[i- 1][j] + dp[i][j], dp[i- 1][j] + dp[i][j + 1]);
            }
        }
        
            System.out.println(dp[1][1]);
        }
        
    }

