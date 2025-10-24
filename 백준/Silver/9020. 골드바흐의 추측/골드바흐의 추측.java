import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean[] isPrime = sieve(10000);  

        while (T-- > 0) {
            int n = sc.nextInt();
            int a = n / 2;
            int b = n / 2;

            while (a > 0) {
                if (isPrime[a] && isPrime[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
    }

    private static boolean[] sieve(int max) {
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
