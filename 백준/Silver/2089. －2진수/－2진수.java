import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();

        while (N != 0) {
            int remainder = N % -2;
            N /= -2;

            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }

            result.insert(0, remainder);
        }

        System.out.println(result.toString());
    }
}
