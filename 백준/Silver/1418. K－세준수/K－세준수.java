import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            int maxPrime = getMaxPrimeFactor(i);
            if (maxPrime <= K) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int getMaxPrimeFactor(int num) {
        int maxFactor = 1;
        int factor = 2;

        while (factor * factor <= num) {
            while (num % factor == 0) {
                maxFactor = factor;
                num /= factor;
            }
            factor++;
        }

        if (num > 1) {
            maxFactor = num;
        }

        return maxFactor;
    }
}
