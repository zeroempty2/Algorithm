import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int resultUser = -1;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < minKevinBacon) {
                minKevinBacon = sum;
                resultUser = i;
            }
        }

        System.out.println(resultUser);
    }


    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        
        queue.add(start);
        distance[start] = 0;
        int total = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    total += distance[next];
                    queue.add(next);
                }
            }
        }

        return total;
    }
}
