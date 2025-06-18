import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int t = 0; t < T; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int dx = x2 - x1;
            int dy = y2 - y1;
            int d2 = dx * dx + dy * dy; 
            int sumR = r1 + r2;
            int diffR = Math.abs(r1 - r2);
            int sumR2 = sumR * sumR;
            int diffR2 = diffR * diffR;

            if (d2 == 0 && r1 == r2) {
                System.out.println(-1); 
            } else if (d2 > sumR2 || d2 < diffR2) {
                System.out.println(0); 
            } else if (d2 == sumR2 || d2 == diffR2) {
                System.out.println(1); 
            } else {
                System.out.println(2); 
            }
        }
    }
}
