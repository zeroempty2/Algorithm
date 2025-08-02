import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Long, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        long result = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount) {
                maxCount = value;
                result = key;
            } else if (value == maxCount) {
                result = Math.min(result, key);
            }
        }

        System.out.println(result);
    }
}
