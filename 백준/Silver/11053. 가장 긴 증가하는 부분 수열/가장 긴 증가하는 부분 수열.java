import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 수열 길이 입력
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 수열 입력
        }

        // 이진 탐색을 활용하여 LIS 계산
        ArrayList<Integer> lis = new ArrayList<>(); // LIS 후보 저장 리스트

        for (int num : A) {
            // 이진 탐색으로 삽입 위치 찾기
            int pos = Collections.binarySearch(lis, num);

            // 삽입 위치를 조정 (음수 반환 시 -(삽입 위치) - 1)
            if (pos < 0) {
                pos = -(pos + 1);
            }

            // 삽입 위치에 값 갱신 또는 추가
            if (pos == lis.size()) {
                lis.add(num); // 리스트 끝에 추가
            } else {
                lis.set(pos, num); // 기존 위치 값을 대체
            }
        }

        // LIS 길이 출력
        System.out.println(lis.size());
    }
}
