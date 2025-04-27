import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int packagePrice = sc.nextInt();
            int singlePrice = sc.nextInt();
            minPackage = Math.min(minPackage, packagePrice);
            minSingle = Math.min(minSingle, singlePrice);
        }
        
        int costAllSingle = n * minSingle;
        int costAllPackage = ((n + 5) / 6) * minPackage;
        int costMix = (n / 6) * minPackage + (n % 6) * minSingle;
        
        System.out.println(Math.min(Math.min(costAllSingle, costAllPackage), costMix));
    }
}
