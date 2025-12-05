import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int minH = 256, maxH = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, land[i][j]);
                maxH = Math.max(maxH, land[i][j]);
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestHeight = 0;


        for (int h = 0; h <= 256; h++) {
            long remove = 0; 
            long add = 0;   

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - h;
                    if (diff > 0) {
                        remove += diff;      
                    } else {
                        add += -diff;        
                    }
                }
            }
            if (remove + B < add) continue;
            long time = remove * 2 + add * 1;

            if (time < bestTime || (time == bestTime && h > bestHeight)) {
                bestTime = (int) time;
                bestHeight = h;
            }
        }

        System.out.println(bestTime + " " + bestHeight);
    }
}