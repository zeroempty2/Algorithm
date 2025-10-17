import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] houses = new long[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextLong();
        }

        Arrays.sort(houses);

        // 중앙값 
        long antenna = houses[(N - 1) / 2];

        System.out.println(antenna);
    }
}
