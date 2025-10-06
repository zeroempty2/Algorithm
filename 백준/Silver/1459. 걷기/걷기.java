import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long dx = Math.abs(X);
        long dy = Math.abs(Y);
        long small = Math.min(dx, dy);
        long big = Math.max(dx, dy);
        long diff = big - small;
        long ans1 = (dx + dy) * W;
        long ans2 = small * S + diff * W;

        long ans3;
        if (S < W) {
            ans3 = small * S + (diff / 2) * 2 * S + (diff % 2) * W;
        } else {
            ans3 = Long.MAX_VALUE / 4;
        }

        long result = Math.min(ans1, Math.min(ans2, ans3));
        System.out.println(result);
    }
}
