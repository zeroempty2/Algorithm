import java.util.*;

public class Main {
    static char[][] board;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int minPaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minPaint = Math.min(minPaint, repaintCount(i, j));
            }
        }

        System.out.println(minPaint);
        sc.close();
    }

    static int repaintCount(int x, int y) {
        int count1 = 0; // 왼쪽 위가 'W'인 경우
        int count2 = 0; // 왼쪽 위가 'B'인 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColor1 = ((i + j) % 2 == 0) ? 'W' : 'B'; // W로 시작하는 경우
                char expectedColor2 = ((i + j) % 2 == 0) ? 'B' : 'W'; // B로 시작하는 경우

                if (board[x + i][y + j] != expectedColor1) count1++;
                if (board[x + i][y + j] != expectedColor2) count2++;
            }
        }

        return Math.min(count1, count2);
    }
}
