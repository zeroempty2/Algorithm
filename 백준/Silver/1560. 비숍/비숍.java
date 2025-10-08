import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();

        if (N.equals(BigInteger.ONE)) {
            System.out.println(1);
        } else {
            BigInteger result = N.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(2));
            System.out.println(result);
        }
    }
}
