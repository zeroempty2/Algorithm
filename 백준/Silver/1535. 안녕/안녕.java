import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] L = new int[N];
        int[] J = new int[N];

        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            J[i] = sc.nextInt();
        }

        int[] dp = new int[100];  

        for (int i = 0; i < N; i++) {
            for (int hp = 99; hp >= L[i]; hp--) {
                dp[hp] = Math.max(dp[hp], dp[hp - L[i]] + J[i]);
            }
        }

        int maxJoy = 0;
        for (int i = 0; i < 100; i++) {
            maxJoy = Math.max(maxJoy, dp[i]);
        }

        System.out.println(maxJoy);
    }
}
