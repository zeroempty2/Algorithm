import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        while (T-- > 0) {
            int N = sc.nextInt();
            Map<Integer, Integer> factors = new LinkedHashMap<>();

            for (int i = 2; i * i <= N; i++) {
                while (N % i == 0) {
                    factors.put(i, factors.getOrDefault(i, 0) + 1);
                    N /= i;
                }
            }

            if (N > 1) {
                factors.put(N, factors.getOrDefault(N, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
