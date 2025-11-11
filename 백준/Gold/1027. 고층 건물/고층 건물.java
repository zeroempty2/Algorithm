import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] h = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Long.parseLong(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                boolean visible = true;

                int start = Math.min(i, j);
                int end = Math.max(i, j);

                for (int k = start + 1; k < end; k++) {
                    double expected =
                            h[start] + (double)(h[end] - h[start]) * (k - start) / (end - start);

                    if (h[k] >= expected) {
                        visible = false;
                        break;
                    }
                }

                if (visible) count++;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
