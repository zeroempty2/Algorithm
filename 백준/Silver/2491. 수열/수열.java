import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int up = 1, down = 1, maxLen = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                up++;
            } else {
                up = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                down++;
            } else {
                down = 1;
            }

            maxLen = Math.max(maxLen, Math.max(up, down));
        }

        System.out.println(maxLen);
    }
}
