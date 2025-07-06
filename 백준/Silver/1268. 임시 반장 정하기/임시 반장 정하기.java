import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        int[][] student = new int[N][5]; 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;    
        int leader = 0;      

        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                for (int k = 0; k < 5; k++) {
                    if (student[i][k] == student[j][k]) {
                        count++;
                        break; 
                    }
                }
            }


            if (count > maxCount) {
                maxCount = count;
                leader = i;
            }
        }


        System.out.println(leader + 1);
    }
}
