import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = sc.nextLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        String bestSeller = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                bestSeller = title;
            } else if (count == maxCount && title.compareTo(bestSeller) < 0) {
                bestSeller = title;
            }
        }

        System.out.println(bestSeller);
    }
}