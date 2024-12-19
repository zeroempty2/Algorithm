import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 노드의 개수
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            String[] input = bf.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // 부모를 저장할 배열
        int[] parent = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 루트 노드 (1번 노드)부터 시작
        parent[1] = -1; // 루트 노드는 부모가 없으므로 -1로 표시

        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : tree.get(current)) {
                if (parent[neighbor] == 0) { // 아직 방문하지 않은 노드라면
                    parent[neighbor] = current; // 현재 노드를 부모로 기록
                    queue.add(neighbor);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
}
