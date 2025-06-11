import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] requests = new int[n];

        int maxRequest = 0;
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
            if (requests[i] > maxRequest) {
                maxRequest = requests[i];
            }
        }

        int totalBudget = sc.nextInt();

        int sum = 0;
        for (int r : requests) sum += r;

        if (sum <= totalBudget) {
            System.out.println(maxRequest);
        } else {
            System.out.println(findMaxCap(requests, totalBudget));
        }
    }

    public static int findMaxCap(int[] requests, int totalBudget) {
        int left = 0;
        int right = Arrays.stream(requests).max().getAsInt();
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int r : requests) {
                sum += Math.min(r, mid);
            }

            if (sum <= totalBudget) {
                result = mid; 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
