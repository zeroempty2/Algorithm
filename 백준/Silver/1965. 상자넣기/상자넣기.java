import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 상자 개수
        int[] box = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            box[i] = sc.nextInt();
            dp[i] = 1;  
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
