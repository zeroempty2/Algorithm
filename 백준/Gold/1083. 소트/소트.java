import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];

        for(int j = 0; j < N; j++){
            arr[j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

            S -= (maxIdx - i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for(int k = 1; k < N; k++){
            sb.append(" ");
            sb.append(arr[k]);
        }

        System.out.println(sb);
    }

}
