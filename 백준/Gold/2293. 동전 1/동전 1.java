import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());
    int[] coin = new int[n + 1];
    int[] dp = new int[10001];
    for(int i = 1; i < n + 1; i++){
      coin[i] = Integer.valueOf(bf.readLine());
    }
    dp[0] = 1;
    for(int i = 1; i < n + 1; i++){
      for(int j = coin[i]; j < k + 1; j++){
        dp[j] += dp[j - coin[i]];
      }
    }
    System.out.println(dp[k]);

}
}