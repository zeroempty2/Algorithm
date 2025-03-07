import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int high = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        binarySearch(M, 0, high);
        System.out.println(answer);
    }

    public static void binarySearch(int M, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            long G = 0; 

            for (int height : arr) {
                if (height > mid) {
                    G += height - mid;
                    if (G >= M) break; 
                }
            }

            if (G >= M) { 
                answer = mid;
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
    }
}
