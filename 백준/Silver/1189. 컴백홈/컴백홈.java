import java.util.*;

public class Main {
    static int R, C, K;
    static char[][] board;
    static boolean[][] visited;
    static int result = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine(); 

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = sc.nextLine().toCharArray();
        }


        visited[R-1][0] = true;  // 시작 위치 방문 처리
        dfs(R - 1, 0, 1);


        System.out.println(result);
    }

    static void dfs(int x, int y, int distance) {
        // 목적지 도착 & 거리 K일 때 경우의 수 증가
        if (x == 0 && y == C - 1) {
            if (distance == K) {
                result++;
            }
            return;
        }

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 내 방문 안 했고 이동 가능할 때만 탐색
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[nx][ny] && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    dfs(nx, ny, distance + 1);
                    visited[nx][ny] = false; // 백트래킹
                }
            }
        }
    }
}
