import java.io.*;
import java.util.*;

public class Main {
    static int[] arr; // 현재 선택한 숫자 저장
    static boolean[] visited; // 각 숫자의 사용 여부 확인
    static int N, M; // N: 숫자의 개수, M: 선택할 숫자의 개수
    static StringBuilder sb = new StringBuilder();
    static int[] nums; // 입력 숫자 저장

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        arr = new int[M]; // 길이 M인 배열 생성 (선택한 숫자 저장)
        visited = new boolean[N]; // 숫자 사용 여부 체크

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 사전순 출력을 위해 정렬
        permutation(0); // 순열 계산 시작
        System.out.print(sb);
    }

    public static void permutation(int depth) {
        // 수열이 완성된 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 모든 숫자를 순회하며 순열 생성
        for (int i = 0; i < N; i++) { 
            if (!visited[i]) { // 현재 숫자가 아직 사용되지 않았다면
                visited[i] = true; // 사용 처리
                arr[depth] = nums[i]; // 현재 위치에 숫자 저장
                permutation(depth + 1); // 다음 깊이로 이동
                visited[i] = false; // 백트래킹: 사용 상태 복구
            }
        }
    }
}
