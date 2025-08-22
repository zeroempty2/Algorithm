import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        System.out.println(combination(n, m));
    }

    public static BigInteger combination(int n, int m) {
        // nCm = n! / (m! * (n-m)!)
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(m).multiply(factorial(n - m));
        return numerator.divide(denominator);
    }

    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
