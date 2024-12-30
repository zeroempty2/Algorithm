import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(bf.readLine()); // 열의 개수
            int[][] arr = new int[3][N + 1];

            // 스티커 점수 입력
            for (int i = 1; i <= 2; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 배열 초기화
            int[][] dp = new int[3][N + 1];

            // 초기값 설정
            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            // 점화식에 따라 dp 계산
            for (int j = 2; j <= N; j++) {
                dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + arr[1][j];
                dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[2][j];
            }

            // 결과 출력 (두 행 중 최댓값)
            sb.append(Math.max(dp[1][N], dp[2][N])).append("\n");
        }

        System.out.println(sb);
    }
}

