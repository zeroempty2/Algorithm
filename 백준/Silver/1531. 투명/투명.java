import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] board = new int[101][101];

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

   
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y]++;
                }
            }
        }

        int count = 0;


        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (board[x][y] > M) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
