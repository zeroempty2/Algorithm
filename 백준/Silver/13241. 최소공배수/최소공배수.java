import java.util.Scanner;

public class Main {

    // 유클리드 호제법
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long g = gcd(A, B);
        long lcm = (A / g) * B;  
        System.out.println(lcm);
    }
}
