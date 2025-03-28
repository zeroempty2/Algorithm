import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] path = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                path[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++) { 
            for (int i = 0; i < N; i++) {  // 시작 노드
                for (int j = 0; j < N; j++) {  // 도착 노드
                    if (path[i][k] == 1 && path[k][j] == 1) {
                        path[i][j] = 1;
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
