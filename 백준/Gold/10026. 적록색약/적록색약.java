import java.util.*;

public class Main {
    static int N; // 그리드 크기
    static char[][] grid; // 원본 그리드
    static boolean[][] visited; // 방문 여부 체크
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 방향
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new char[N][N];
        visited = new boolean[N][N];

        // 그리드 입력
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray();
        }

        // 적록색약이 아닌 경우 구역 계산
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                    normalCount++;
                }
            }
        }

        // 적록색약인 경우 구역 계산
        visited = new boolean[N][N]; // 방문 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R') {
                    grid[i][j] = 'G'; // 적록색약: R과 G를 동일 처리
                }
            }
        }

        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                    colorBlindCount++;
                }
            }
        }

        // 결과 출력
        System.out.println(normalCount + " " + colorBlindCount);
    }

    // BFS 탐색
    static void bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && grid[nx][ny] == color) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
