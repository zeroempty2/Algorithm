import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // DNA 개수
        int M = sc.nextInt(); // DNA 길이
        
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = sc.next();
        }
        
        StringBuilder result = new StringBuilder();
        int distanceSum = 0;

        for (int col = 0; col < M; col++) {
            int[] count = new int[4]; 
            
            // 빈도 카운트
            for (int row = 0; row < N; row++) {
                char c = dna[row].charAt(col);
                if (c == 'A') count[0]++;
                else if (c == 'C') count[1]++;
                else if (c == 'G') count[2]++;
                else if (c == 'T') count[3]++;
            }

            int maxIdx = 0;
            for (int i = 1; i < 4; i++) {
                if (count[i] > count[maxIdx]) {
                    maxIdx = i;
                }
            }
            
            char chosen;
            if (maxIdx == 0) chosen = 'A';
            else if (maxIdx == 1) chosen = 'C';
            else if (maxIdx == 2) chosen = 'G';
            else chosen = 'T';
            
            result.append(chosen);
            
            distanceSum += (N - count[maxIdx]);
        }
        
        System.out.println(result.toString());
        System.out.println(distanceSum);
    }
}
