import java.io.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1; 
            dp[i][i] = 1; 
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 
            }
        }

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); 
            int M = Integer.parseInt(input[1]); 

            System.out.println(dp[M][N]);
        }
    }
}
