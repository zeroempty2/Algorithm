import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < C; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            double avg = (double) sum / N;

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > avg) count++;
            }

            double result = (double) count / N * 100.0;

            sb.append(String.format("%.3f%%\n", result));
        }

        System.out.print(sb);
    }
}
