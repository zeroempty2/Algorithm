import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int[] A = new int[K + 1];
        int[] B = new int[K + 1];

        A[0] = 1; 
        B[0] = 0;

        for (int i = 1; i <= K; i++) {
            A[i] = B[i - 1];
            B[i] = A[i - 1] + B[i - 1];
        }

        System.out.println(A[K] + " " + B[K]);
    }
}