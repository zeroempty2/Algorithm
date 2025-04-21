import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (map[i][j] == 'Y') {
                    // 직접 친구
                    visited[j] = true;
                } else {
                    // 친구의 친구 확인
                    for (int k = 0; k < n; k++) {
                        if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }

            for (boolean b : visited) {
                if (b) count++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
