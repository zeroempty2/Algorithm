import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] people = new int[N][2];

        int maxPay = 0;
        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
            maxPay = Math.max(maxPay, people[i][0]);
        }

        int maxProfit = 0;
        int bestPrice = 0;

        for (int price = 1; price <= maxPay; price++) {
            int profit = 0;

            for (int i = 0; i < N; i++) {
                int maxPayment = people[i][0];
                int shipCost = people[i][1];

                if (price <= maxPayment) {
                    int margin = price - shipCost;
                    if (margin > 0) {
                        profit += margin;
                    }
                }
            }

            if (profit > maxProfit || (profit == maxProfit && price < bestPrice)) {
                maxProfit = profit;
                bestPrice = price;
            }
        }

        System.out.println(maxProfit > 0 ? bestPrice : 0);
    }
}
