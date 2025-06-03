import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int maxLen = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 1; i + d < N && j + d < M; d++) {
                    int a = map[i][j];
                    int b = map[i][j + d];
                    int c = map[i + d][j];
                    int dVal = map[i + d][j + d];

                    if (a == b && a == c && a == dVal) {
                        maxLen = Math.max(maxLen, d + 1);
                    }
                }
            }
        }

        System.out.println(maxLen * maxLen); 
    }
}
