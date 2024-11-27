import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2^N 크기
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열

        System.out.println(z(N, r, c));
    }

    public static int z(int N, int r, int c) {
        int result = 0;
        int size = 1 << (N - 1); // 현재 사분면 크기 (2^(N-1))

        while (N > 0) { // 1 x 1 이 될때까지 반복
            // 사분면 계산
            int quad = 0;
             // r이 size보다 큰 경우 하단 사분면
            if (r >= size) {
                quad += 2;
                r -= size;
            }
            // c가 size보다 큰 경우 오른쪽 사분면
            if (c >= size) { 
                quad += 1;
                c -= size;
            }

            //quad = 사분면의 구역(0,1,2,3) ex) 3 7 7 인 경우 4분면의 우하단 영역에 위치하므로 quad = 3
            // 결과에 현재 사분면의 시작 순서를 더함 ex) 3 7 7인 경우 4 x 4 사이즈, 3 * 4 * 4 = 48 이 3번째 사분면의 시작 순서
            result += quad * size * size;

            // 사분면 크기 반으로 줄임
            size /= 2;
            N--;
        }

        return result;
    }
}
