import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        if (T == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            dp[i] = i; 
        }
 
        for (int i = 1; i <= T; i++) {
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }

        System.out.println(dp[T]);
    }
}
