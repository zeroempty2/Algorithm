import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int[][] pattern = {
                {},             // 0 
                {1},            // 1
                {2,4,8,6},      // 2
                {3,9,7,1},      // 3
                {4,6},          // 4
                {5},            // 5
                {6},            // 6
                {7,9,3,1},      // 7
                {8,4,2,6},      // 8
                {9,1}           // 9
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = a % 10;
            if (d == 0) {
                sb.append(10).append('\n');
                continue;
            }
            int index = (b - 1) % pattern[d].length;
            sb.append(pattern[d][index]).append('\n');
        }

        System.out.print(sb);
    }
}