import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        long max = 0; 

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(N, max));
    }

    public static long binarySearch(int N, long max) {
        long low = 1;
        long high = max;
        long result = 0; 

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = countLanCables(mid);

            if (count >= N) { 
                result = mid; 
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
        return result;
    }

    public static long countLanCables(long length) {
        long count = 0;
        for (int lan : arr) {
            count += (lan / length); 
        }
        return count;
    }
}
