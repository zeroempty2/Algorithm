import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        // 방문 여부 체크 배열
        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        
        // 초기 위치 삽입: [현재 위치, 시간]
        queue.add(new int[] { N, 0 });
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            // 동생 위치에 도달한 경우 최단 시간 반환
            if (position == K) {
                return time;
            }

            // 다음 위치로 이동
            int[] nextPositions = { position * 2, position - 1, position + 1 };
            for (int next : nextPositions) {
                // 범위 내에 있고 방문하지 않은 위치만 큐에 추가
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;


                    if (next == position * 2) {
                        queue.add(new int[] { next, time + 1});
                    } else {
                        queue.add(new int[] { next, time + 1 });
                    }
                }
            }
        }
        return -1; 
    }
}
