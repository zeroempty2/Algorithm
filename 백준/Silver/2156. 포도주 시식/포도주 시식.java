import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                Math.max(dp[i - 1], dp[i - 2] + wine[i]),
                dp[i - 3] + wine[i - 1] + wine[i]
            );
        }

        System.out.println(dp[n]);
    }
}
