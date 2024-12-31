import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city, cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // 비용 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 버스의 개수

        // 그래프 초기화 (인접 리스트)
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(u).add(new Node(v, cost));
        }

        int start = sc.nextInt(); // 시작 도시
        int end = sc.nextInt();   // 도착 도시

        // 다익스트라 알고리즘 실행
        int result = dijkstra(start, end, graph, n);

        // 최소 비용 출력
        System.out.println(result);
    }

    static int dijkstra(int start, int end, List<List<Node>> graph, int n) {
        // 최소 비용 배열 초기화
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 우선순위 큐 (최소 힙)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currCity = current.city;
            int currCost = current.cost;

            // 이미 처리된 도시라면 무시
            if (currCost > distance[currCity]) continue;

            // 인접 도시 탐색
            for (Node next : graph.get(currCity)) {
                int nextCity = next.city;
                int nextCost = next.cost;

                // 현재까지의 비용 + 이동 비용 계산
                int totalCost = currCost + nextCost;

                if (totalCost < distance[nextCity]) {
                    distance[nextCity] = totalCost;
                    pq.offer(new Node(nextCity, totalCost));
                }
            }
        }

        return distance[end]; // 도착 도시까지의 최소 비용 반환
    }
}
