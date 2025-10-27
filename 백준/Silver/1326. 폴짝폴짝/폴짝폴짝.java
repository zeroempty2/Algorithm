import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] stone;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stone = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(a, b));
    }

    static int bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        q.offer(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];
            
            if (pos == target) return cnt;
            
            int step = stone[pos];
            

            for (int next = pos + step; next <= N; next += step) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
            

            for (int next = pos - step; next >= 1; next -= step) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}
