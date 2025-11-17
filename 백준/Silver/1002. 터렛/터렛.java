import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            long dx = x2 - x1;
            long dy = y2 - y1;
            long d2 = dx*dx + dy*dy; 
            long sumR = r1 + r2;
            long diffR = Math.abs(r1 - r2);
            
            // X
            if (d2 == 0 && r1 == r2) {
                sb.append(-1).append('\n');
                continue;
            }
            // 만나지 않음 
            if (d2 > sumR * sumR || d2 < diffR * diffR) {
                sb.append(0).append('\n');
                continue;
            }
            // 한 점에서 접함 
            if (d2 == sumR * sumR || d2 == diffR * diffR) {
                sb.append(1).append('\n');
                continue;
            }
            // 두 점에서 만남
            sb.append(2).append('\n');
        }

        System.out.print(sb);
    }
}