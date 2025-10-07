import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[6][6];
        List<int[]> path = new ArrayList<>();

        for (int i = 0; i < 36; i++) {
            String s = br.readLine();
            int x = s.charAt(0) - 'A'; // A~F → 0~5
            int y = s.charAt(1) - '1'; // 1~6 → 0~5
            path.add(new int[]{x, y});
        }

        for (int[] p : path) {
            if (visited[p[0]][p[1]]) {
                System.out.println("Invalid");
                return;
            }
            visited[p[0]][p[1]] = true;
        }

        for (int i = 0; i < 35; i++) {
            if (!isKnightMove(path.get(i), path.get(i + 1))) {
                System.out.println("Invalid");
                return;
            }
        }

        if (!isKnightMove(path.get(35), path.get(0))) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

    static boolean isKnightMove(int[] a, int[] b) {
        int dx = Math.abs(a[0] - b[0]);
        int dy = Math.abs(a[1] - b[1]);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
