import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr; // 입력된 숫자 배열
    static int[] result; // 선택된 숫자를 저장할 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];

        // 입력된 숫자 배열 초기화 및 정렬
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 비내림차순 출력을 위해 정렬

        // 백트래킹 시작
        backtrack(0, 0);
        System.out.print(sb);
    }

    public static void backtrack(int depth, int start) {
        if (depth == M) { // 길이가 M인 조합 생성 완료
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1; // 이전에 사용한 숫자를 추적
        for (int i = start; i < N; i++) {
            if (arr[i] == lastUsed) {
                continue; // 이전에 사용한 숫자와 동일하면 건너뜀
            }

            result[depth] = arr[i]; // 현재 숫자 선택
            lastUsed = arr[i]; // 이전에 사용한 숫자 업데이트
            backtrack(depth + 1, i); // i를 넘겨 현재 숫자를 다시 선택 가능
        }
    }
}
