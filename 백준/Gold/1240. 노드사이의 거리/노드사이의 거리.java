import java.util.*;

public class Main {
    static List<List<Node>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int bfs(int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Node next : tree.get(curr)) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    dist[next.to] = dist[curr] + next.weight;
                    queue.add(next.to);
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 쿼리 수

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 입력
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            tree.get(a).add(new Node(b, d));
            tree.get(b).add(new Node(a, d)); 
        }


        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println(bfs(u, v, N));
        }
    }
}
