import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr; // 입력된 숫자 배열
    static int[] result; // 선택된 숫자를 저장할 배열
    static boolean[] visited; // 방문 여부 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        // 입력된 숫자 배열 초기화 및 정렬
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 사전 순 출력을 위해 정렬

        // 백트래킹 시작
        backtrack(0);
        System.out.print(sb);
    }

    public static void backtrack(int depth) {
        if (depth == M) { // 길이가 M인 수열 생성 완료
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            // 같은 숫자를 연속으로 선택하지 않도록 처리
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (!visited[i]) { // 아직 방문하지 않은 숫자
                visited[i] = true; // 방문 처리
                result[depth] = arr[i]; // 현재 숫자 선택
                backtrack(depth + 1); // 다음 위치 탐색
                visited[i] = false; // 방문 해제 (백트래킹)
            }
        }
    }
}
