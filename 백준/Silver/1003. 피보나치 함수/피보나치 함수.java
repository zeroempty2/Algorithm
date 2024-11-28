import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        // 최대 입력값 N을 처리할 수 있도록 배열 크기 설정
        int maxN = 41;  // 문제에서 N의 최대 값은 40이므로 41로 설정
        
        // DP 배열 선언 (fibo 배열에 피보나치 수에 대한 0과 1의 출력 횟수 저장)
        int[][] dp = new int[maxN + 1][2];
        
        // 초기값 설정 (0, 1에 대해 0과 1의 출력 횟수는 각각 1번씩)
        dp[0][0] = 1; // fibonacci(0)에서 0이 1번 출력됨
        dp[0][1] = 0; // fibonacci(0)에서 1은 출력되지 않음
        dp[1][0] = 0; // fibonacci(1)에서 0은 출력되지 않음
        dp[1][1] = 1; // fibonacci(1)에서 1이 1번 출력됨
        
        // DP 테이블 채우기 (2부터 maxN까지)
        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];  // fibonacci(i)에서 0의 출력 횟수는 fibonacci(i-1)과 fibonacci(i-2)에서 출력된 0의 횟수 합
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];  // fibonacci(i)에서 1의 출력 횟수는 fibonacci(i-1)과 fibonacci(i-2)에서 출력된 1의 횟수 합
        }
        
        // T개의 테스트 케이스에 대해 결과 출력
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(bf.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);  // dp[N][0]과 dp[N][1]에 저장된 0과 1의 출력 횟수 출력
        }
    }
}
