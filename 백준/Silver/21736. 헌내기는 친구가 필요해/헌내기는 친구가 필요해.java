import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        // I의 위치 찾기
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        int result = bfs(startX, startY);
        System.out.println(result == 0 ? "TT" : result);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위 체크 및 방문 여부 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    if (campus[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if (campus[nx][ny] == 'P') {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
