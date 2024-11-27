import java.io.*;
import java.util.*;

public class Main {
    static int[][] directions = {
        {-1, 0}, // 위
        {1, 0},  // 아래
        {0, -1}, // 왼쪽
        {0, 1}   // 오른쪽
    };  
      public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<int[]> queue = new LinkedList<>();
        int unripe = 0;
        int days = 0;
        //가로
        int M = Integer.parseInt(st.nextToken());
        //세로
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];        

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                int tomato = Integer.parseInt(st.nextToken());
                if(tomato == 1){
                    queue.add(new int[]{i,j,0});
                    box[i][j] = 1;
                }
                else if(tomato == 0){
                    unripe++;
                }
                else{
                    box[i][j] = -1;
                }
            }
        }

        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            days = current[2];

            for(int[] arr: directions){
                int nx = x + arr[0];
                int ny = y + arr[1];
                //상하좌우로 튀어나가지 않는 범위내에서 tomato가 0일때
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0){
                    box[nx][ny] = 1; // 익게 처리
                    unripe--;
                    queue.add(new int[]{nx, ny, days + 1});
                }
            }
        }

        System.out.println(unripe > 0 ? -1 : days);
      }
}