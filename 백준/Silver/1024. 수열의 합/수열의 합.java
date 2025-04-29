import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();  // 합
        int L = sc.nextInt();    // 최소 길이

        for (int len = L; len <= 100; len++) {
            long numerator = N - (long) len * (len - 1) / 2;
            if (numerator < 0) break;  // 시작값이 음수면 불가능
            if (numerator % len == 0) {
                long x = numerator / len;
                for (int i = 0; i < len; i++) {
                    System.out.print((x + i) + " ");
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
