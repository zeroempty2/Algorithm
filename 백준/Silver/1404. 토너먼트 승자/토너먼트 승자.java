import java.util.*;

public class Main {
    static double[][] win = new double[8][8];  // i가 j를 이길 확률
    static double[] prob = new double[8];     // 각 참가자가 우승할 확률

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 승률 입력: win[i][j]를 채움
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                double val = sc.nextDouble() / 100.0;
                win[i][j] = val;
                win[j][i] = 1.0 - val;
            }
        }

        // 초기 확률 (Round 0): 모두 1
        double[][] dp = new double[4][8];
        for (int i = 0; i < 8; i++) dp[0][i] = 1.0;

        // Round 1 (0 vs 1), (2 vs 3), ...
        for (int i = 0; i < 8; i++) {
            int groupStart = i / 2 * 2;
            for (int j = groupStart; j < groupStart + 2; j++) {
                if (i == j) continue;
                dp[1][i] += dp[0][i] * dp[0][j] * win[i][j];
            }
        }

        // Round 2 ((0~3) vs (4~7))
        for (int i = 0; i < 8; i++) {
            int groupStart = (i / 4) * 4;
            for (int j = groupStart; j < groupStart + 4; j++) {
                if (i == j || (j / 2 == i / 2)) continue;
                dp[2][i] += dp[1][i] * dp[1][j] * win[i][j];
            }
        }

        // Round 3 (결승)
        for (int i = 0; i < 8; i++) {
            int groupStart = (i < 4) ? 4 : 0;
            for (int j = groupStart; j < groupStart + 4; j++) {
                dp[3][i] += dp[2][i] * dp[2][j] * win[i][j];
            }
        }

        // 결과 출력
        for (int i = 0; i < 8; i++) {
            System.out.printf("%.10f ", dp[3][i]);
        }
    }
}
