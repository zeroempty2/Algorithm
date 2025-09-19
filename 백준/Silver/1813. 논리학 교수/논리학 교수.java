import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int answer = -1;

        for (int T = 0; T <= N; T++) {
            int cnt = 0;
            for (int x : arr) {
                if (x == T) cnt++;
            }
            if (cnt == T) {
                answer = Math.max(answer, T); 
            }
        }

        System.out.println(answer);
    }
}
