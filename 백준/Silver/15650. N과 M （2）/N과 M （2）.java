import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; // 길이 M인 배열 생성 (선택한 숫자 저장)
        combination(1, 0); // 조합 계산 시작 (숫자는 1부터 시작)
        System.out.print(sb);
    }

    public static void combination(int start, int depth) {
        // 수열이 완성된 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // start부터 N까지 숫자를 선택
        for (int i = start; i <= N; i++) { 
            arr[depth] = i; // 현재 위치에 숫자 선택
            combination(i + 1, depth + 1); // 다음 위치를 선택
        }
    }
}



