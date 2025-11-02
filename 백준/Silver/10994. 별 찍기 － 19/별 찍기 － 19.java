import java.io.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 4 * N - 3;

        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        draw(0, size, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void draw(int start, int size, int n) {
        if (n == 0) return;

        int end = start + size - 1;

        // 위, 아래
        for (int i = start; i <= end; i++) {
            map[start][i] = '*';
            map[end][i] = '*';
        }

        // 왼쪽, 오른쪽
        for (int i = start; i <= end; i++) {
            map[i][start] = '*';
            map[i][end] = '*';
        }

        // 내부 사각형 그리기 
        draw(start + 2, size - 4, n - 1);
    }
    }