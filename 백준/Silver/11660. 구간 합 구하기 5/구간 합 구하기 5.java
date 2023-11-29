import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[][] arr = new int[A + 1][A + 1];
    for(int i = 1; i < A + 1; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 1; j < A + 1; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }
   int[][] dp = new int[A + 1][A + 1];
   for(int i = 1; i < A + 1; i++){
        for(int j = 1; j < A + 1; j++){
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
        }
    }
    for(int i = 0; i < B; i++){
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
        System.out.println(result);
    }
    br.close();
}
}