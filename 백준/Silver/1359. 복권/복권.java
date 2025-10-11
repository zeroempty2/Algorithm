import java.util.*;
public class Main {
    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        long denom = comb(N, M);
        long numer = 0;
        for (int j = K; j <= M; j++) {
            numer += comb(M, j) * comb(N - M, M - j);
        }

        double ans = (double) numer / (double) denom;
        System.out.printf("%.10f\n", ans);
    }
}
