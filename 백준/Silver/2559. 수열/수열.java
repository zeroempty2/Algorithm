import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        int maxSum = sum;

        // 슬라이딩 윈도우
        for (int i = K; i < N; i++) {
            sum = sum - temp[i - K] + temp[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
