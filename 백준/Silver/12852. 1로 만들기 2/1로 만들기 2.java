import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = i;
        }

        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i / 3] + 1;
                arr[i] = i / 3;
            }
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                arr[i] = i/2;
            }
            if(i - 1 > 0 && dp[i] > dp[i - 1] + 1){
                dp[i] = dp[i - 1] + 1;
                arr[i] = i - 1;
            }
        }
        
        bw.write(String.valueOf(dp[n])+'\n');
        int num = n;
        for(int i = 0; i <= dp[n]; i++){
            bw.write(String.valueOf(num) + " ");
            num = arr[num];
        }

        bw.flush();

    }
  }