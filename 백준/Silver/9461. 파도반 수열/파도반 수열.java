import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());

            // 초기값 처리
            if (N == 1 || N == 2 || N == 3) {
                sb.append(1).append("\n");
                continue;
            }

            // 점화식 계산
            long[] dp = new long[N + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
