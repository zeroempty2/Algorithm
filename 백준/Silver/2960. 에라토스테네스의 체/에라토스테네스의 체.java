import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] deleted = new boolean[N + 1];
        int count = 0;

        for (int p = 2; p <= N; p++) {
            if (!deleted[p]) { 
                for (int multiple = p; multiple <= N; multiple += p) {
                    if (!deleted[multiple]) {
                        deleted[multiple] = true;
                        count++;
                        if (count == K) {
                            System.out.println(multiple);
                            return;
                        }
                    }
                }
            }
        }
    }
}
