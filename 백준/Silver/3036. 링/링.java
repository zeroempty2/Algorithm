import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] radius = new int[N];
        for (int i = 0; i < N; i++) {
            radius[i] = sc.nextInt();
        }

        int first = radius[0];

        for (int i = 1; i < N; i++) {
            int g = gcd(first, radius[i]);
            System.out.println((first / g) + "/" + (radius[i] / g));
        }
    }
}
