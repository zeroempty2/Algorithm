import java.util.*;

public class Main {
    static int n, start, end, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        start = sc.nextInt(); 
        end = sc.nextInt(); 
        m = sc.nextInt(); 

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph[parent].add(child);
            graph[child].add(parent); 
        }

        bfs(start);

        System.out.println(distance[end] == 0 ? (start == end ? 0 : -1) : distance[end]);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
