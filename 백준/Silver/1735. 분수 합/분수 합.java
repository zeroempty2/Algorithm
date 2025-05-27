import java.util.Scanner;

public class Main {
    // 유클리드 호제법 GCD 구하기
    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); 
        int B = sc.nextInt();  
        int C = sc.nextInt();  
        int D = sc.nextInt(); 
        
        int numerator = A * D + C * B;     
        int denominator = B * D;          

        int gcd = gcd(numerator, denominator);  // 최대공약수

        System.out.println((numerator / gcd) + " " + (denominator / gcd));
    }
}
