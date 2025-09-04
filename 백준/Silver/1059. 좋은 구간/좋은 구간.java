import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int[] S = new int[L];
        for (int i = 0; i < L; i++) {
            S[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        Arrays.sort(S);

        // n이 S에 있으면 0
        for (int s : S) {
            if (s == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;   // n보다 작은 가장 큰 수
        int right = 1001; // n보다 큰 가장 작은 수 

        for (int s : S) {
            if (s < n) left = Math.max(left, s);
            if (s > n) {
                right = Math.min(right, s);
            }
        }

        int A = n - (left + 1) + 1;  // 가능한 A 개수
        int B = (right - 1) - n + 1; // 가능한 B 개수

        int result = A * B - 1;

        System.out.println(result);
    }
}
