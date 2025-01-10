import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로의 크기
        int m = Integer.parseInt(st.nextToken()); // 가로의 크기
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] distances = new int[n][m];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                    distances[i][j] = 0; // 목표 지점의 거리는 0
                }
            }
        }

        // BFS 탐색
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효 범위 확인 및 방문 여부 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && distances[nx][ny] == -1 && grid[nx][ny] != 0) {
                    distances[nx][ny] = distances[x][y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) { // 벽인 경우 0 유지
                    sb.append("0 ");
                } else {
                    sb.append(distances[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
