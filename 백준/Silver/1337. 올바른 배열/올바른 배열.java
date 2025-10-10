import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); 
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            while (arr[right] - arr[left] >= 5) {
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        System.out.println(5 - maxCount);
    }
}
