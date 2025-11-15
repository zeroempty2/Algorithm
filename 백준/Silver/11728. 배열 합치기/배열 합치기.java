import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //배열 A,B의 길이 N,M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        // 배열 채우기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int a = 0 , b = 0, point = 0;
        
        //값 비교하기
        for(int i = 0; i < N+M; i++){
            if(a < N && b < M){
                if (A[a] <= B[b]) {
                    sb.append(A[a++]).append(" ");
                } 
                else {
                    sb.append(B[b++]).append(" ");
                }
            }
            else{
                point = i;
                break;
            }
        }

        //남은 부분
        if(a < N){
            for(int i = point; i < N+M; i++) sb.append(A[a++]).append(" ");
            
        }
        else if(b < M){
            for(int i = point; i < N+M; i++) sb.append(B[b++]).append(" ");
        }

        System.out.println(sb);
            
    }
}
