import java.io.*;
import java.util.*;

public class Main {
    static class Circle {
        int cx, cy, r;

        public Circle(int cx, int cy, int r) {
            this.cx = cx;
            this.cy = cy;
            this.r = r;
        }

        public boolean isInside(int x, int y) {
            int dx = x - cx;
            int dy = y - cy;
            return dx * dx + dy * dy < r * r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            Circle[] circles = new Circle[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                circles[i] = new Circle(cx, cy, r);
            }

            int count = 0;
            for (Circle c : circles) {
                boolean startInside = c.isInside(x1, y1);
                boolean endInside = c.isInside(x2, y2);

                if (startInside != endInside) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
