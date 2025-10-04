import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Ti = Integer.parseInt(st.nextToken());

            long candidate = 0;
            int count = 0;
            long[] soldiers = new long[Ti];

            for (int j = 0; j < Ti; j++) {
                long num = Long.parseLong(st.nextToken());
                soldiers[j] = num;
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }

            int freq = 0;
            for (long s : soldiers) {
                if (s == candidate) freq++;
            }

            if (freq > Ti / 2) {
                sb.append(candidate).append("\n");
            } else {
                sb.append("SYJKGW\n");
            }
        }

        System.out.print(sb);
    }
}
