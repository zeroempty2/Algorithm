import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 계단의 개수
        int[] score = new int[n + 1]; // 각 계단의 점수 (1-indexed)
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        // DP 배열 선언
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = score[1]; // 첫 번째 계단
        if (n >= 2) dp[2] = score[1] + score[2]; // 두 번째 계단

        // DP 점화식 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        // 결과 출력
        System.out.println(dp[n]);

        sc.close();
    }
}
