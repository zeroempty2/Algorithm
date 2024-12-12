import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[1001];
        dp[1] = 1; dp[2] = 3;
        for(int i = 3; i <= N; i++){
          dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
      }
}
