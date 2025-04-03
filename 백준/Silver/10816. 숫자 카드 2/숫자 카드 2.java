import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        Map<Integer, Integer> countMap = new HashMap<>(); 


        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int M = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(countMap.getOrDefault(target, 0)).append(" ");
        }
        
        sc.close();
        System.out.println(sb);
    }
}
