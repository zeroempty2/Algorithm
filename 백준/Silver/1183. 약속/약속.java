import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] C = new long[N];
        
        for (int i = 0; i < N; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            C[i] = A - B;
        }

        Arrays.sort(C);

        long count;
        if (N % 2 == 1) {
            count = 1;
        } else {
            long mid1 = C[N/2 - 1];
            long mid2 = C[N/2];
            count = mid2 - mid1 + 1;
        }

        System.out.println(count);
    }
}
