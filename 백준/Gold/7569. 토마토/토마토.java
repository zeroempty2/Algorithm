import java.io.*;
import java.util.*;

public class Main {
    static int[][] directions = {
        {0, -1, 0}, // 위
        {0, 1, 0},  // 아래
        {-1, 0, 0}, // 왼쪽
        {1, 0, 0},  // 오른쪽
        {0, 0, -1}, // 앞
        {0, 0, 1}   // 뒤
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        int unripe = 0; // 익지 않은 토마토 수

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(bf.readLine());
                for (int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[h][n][m] = tomato;

                    if (tomato == 1) {
                        queue.add(new int[]{h, n, m, 0}); // 익은 토마토 위치 및 날짜
                    } else if (tomato == 0) {
                        unripe++;
                    }
                }
            }
        }

        // 모든 토마토가 이미 익은 경우
        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0]; // 높이
            int x = current[1]; // 세로
            int y = current[2]; // 가로
            days = current[3]; // 경과 일수

            for (int[] dir : directions) {
                int nz = z + dir[0];
                int nx = x + dir[1];
                int ny = y + dir[2];

                // 범위를 벗어나지 않고, 익지 않은 토마토일 경우
                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M && box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = 1; // 익게 처리
                    unripe--;
                    queue.add(new int[]{nz, nx, ny, days + 1});
                }
            }
        }

        // 결과 출력
        System.out.println(unripe > 0 ? -1 : days);
    }
}
