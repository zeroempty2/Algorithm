import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();

        long result = 0;

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (int)((M + 1) / 2));
        } else {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}
