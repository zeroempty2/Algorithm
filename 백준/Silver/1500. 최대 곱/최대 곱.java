import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        int K = sc.nextInt();

        long q = S / K;  
        int r = (int)(S % K);  

        long result = 1;
        for (int i = 0; i < K; i++) {
            if (i < r) {
                result *= (q + 1);
            } else {
                result *= q;
            }
        }

        System.out.println(result);
    }
}
