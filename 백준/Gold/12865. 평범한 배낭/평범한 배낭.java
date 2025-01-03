import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 물건의 무게
        int[] V = new int[N + 1]; // 물건의 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            for(int w = 1; w <= M; w++){
                if(W[i] > w){
                    dp[i][w] = dp[i-1][w];
                }
                else{
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
