import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();    
        int score = sc.nextInt(); 
        int P = sc.nextInt();   

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scores[i] > score) {
                rank++;
            } else {
                break;
            }
        }

        if (N < P) {
            System.out.println(rank);
        }
        else {
            if (scores[N - 1] < score) {
                System.out.println(rank);
            } else {
                System.out.println(-1);
            }
        }
    }
}
