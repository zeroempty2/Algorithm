import java.io.*;

public class Main {
    static int[][] map;
    static int[] count = new int[3]; 

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        cut(0, 0, n);


        System.out.println(count[0]); 
        System.out.println(count[1]); 
        System.out.println(count[2]); 
    }


    static void cut(int x, int y, int size) {
        if (checkSame(x, y, size)) {
            count[map[x][y] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                cut(x + dx * newSize, y + dy * newSize, newSize);
            }
        }
    }

    static boolean checkSame(int x, int y, int size) {
        int value = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != value) return false;
            }
        }
        return true;
    }
}
