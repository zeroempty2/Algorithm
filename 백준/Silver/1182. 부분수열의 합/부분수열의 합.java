import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, s, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, false);
        System.out.println(count);
    }

    static void dfs(int idx, int sum, boolean hasTaken) {
        if (idx == n) {
            if (hasTaken && sum == s) count++;
            return;
        }

        // 현재 원소를 선택하지 않음
        dfs(idx + 1, sum, hasTaken);

        // 현재 원소를 선택함
        dfs(idx + 1, sum + arr[idx], true);
    }
}
