import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] mark = new boolean[5][5];
    static int[][] board = new int[5][5];
    static int[][] pos = new int[26][2]; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                int v = Integer.parseInt(st.nextToken());
                board[r][c] = v;
                pos[v][0] = r; pos[v][1] = c;
            }
        }

        int callCount = 0;
        // 사회자 호출 25개
        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                int v = Integer.parseInt(st.nextToken());
                callCount++;
                // 표시
                int rr = pos[v][0], cc = pos[v][1];
                mark[rr][cc] = true;

                // 빙고 줄 개수 세기
                if (countBingo() >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }
    }

    static int countBingo() {
        int lines = 0;

        // 가로
        for (int r = 0; r < 5; r++) {
            boolean ok = true;
            for (int c = 0; c < 5; c++) if (!mark[r][c]) { ok = false; break; }
            if (ok) lines++;
        }

        // 세로
        for (int c = 0; c < 5; c++) {
            boolean ok = true;
            for (int r = 0; r < 5; r++) if (!mark[r][c]) { ok = false; break; }
            if (ok) lines++;
        }

        // 대각선
        boolean ok = true;
        for (int i = 0; i < 5; i++) if (!mark[i][i]) { ok = false; break; }
        if (ok) lines++;

        // 대각선
        ok = true;
        for (int i = 0; i < 5; i++) if (!mark[i][4 - i]) { ok = false; break; }
        if (ok) lines++;

        return lines;
    }
}
