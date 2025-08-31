import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long L = sc.nextLong();
        long W = sc.nextLong();
        long H = sc.nextLong();

        double low = 0.0;
        double high = Math.min(L, Math.min(W, H));

        for (int i = 0; i < 100; i++) { 
            double mid = (low + high) / 2.0;

            long count = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);

            if (count >= N) {
                low = mid;  
            } else {
                high = mid;  
            }
        }

        System.out.printf("%.10f\n", low);
    }
}
