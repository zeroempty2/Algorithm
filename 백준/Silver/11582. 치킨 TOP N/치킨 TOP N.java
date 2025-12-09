import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();

        int groupSize = N / k;

        for (int start = 0; start < N; start += groupSize) {
            Arrays.sort(arr, start, start + groupSize);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(" ");
        System.out.println(sb.toString());
    }
}
