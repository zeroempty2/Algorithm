import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int M = sc.nextInt(); 

        int[] P = new int[M];
        for (int i = 0; i < M; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int bestPrice = 0;
        long maxProfit = 0;

        for (int i = 0; i < M; i++) {
            int price = P[i]; 
            int buyers = M - i;
            int sellCount = Math.min(N, buyers);
            long profit = (long) sellCount * price;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestPrice = price;
            } else if (profit == maxProfit && price < bestPrice) {
                bestPrice = price;
            }
        }

        System.out.println(bestPrice + " " + maxProfit);
    }
}
