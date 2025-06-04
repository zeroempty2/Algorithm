import java.util.*;

public class Main {
    static int N, M;
    static char[][] floor;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); 

        floor = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        char type = floor[x][y];

        if (type == '-') {
            int ny = y + 1;
            if (ny < M && !visited[x][ny] && floor[x][ny] == '-') {
                dfs(x, ny);
            }
        } else if (type == '|') {
            int nx = x + 1;
            if (nx < N && !visited[nx][y] && floor[nx][y] == '|') {
                dfs(nx, y);
            }
        }
    }
}
