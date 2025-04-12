import java.io.*;
import java.util.*;

public class Main {
    static class Shortcut {
        int start, end, cost;
        public Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int D = Integer.parseInt(st.nextToken()); 

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (e > D) continue;          
            if (e - s <= l) continue;    
            shortcuts.add(new Shortcut(s, e, l));
        }

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) dp[i] = i;

        for (int i = 0; i <= D; i++) {
            if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1); 
            for (Shortcut sc : shortcuts) {
                if (sc.start == i && sc.end <= D) {
                    dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.cost);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
