import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        int[] dp = new int[11];
        
        // 초기값 설정
        dp[0] = 1; 
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 4; 
        

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
