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
    long[] dp = new long[A + 1];
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i < A + 1; i++){
        dp[i] = Integer.parseInt(st.nextToken()) + dp[i - 1];
    }
    for(int i = 0; i < B; i++){
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        System.out.println(dp[x2] - dp[x1 - 1]);
    }
}
}