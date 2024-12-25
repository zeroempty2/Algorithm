import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sortedArr[i] = x;
        }

        // 정렬된 배열 생성
        Arrays.sort(sortedArr);

        // 좌표 압축을 위한 맵핑
        int rank = 0;
        for (int j = 0; j < n; j++) {
            // 이미 매핑된 숫자는 생략 (중복 방지)
            if (!map.containsKey(sortedArr[j])) {
                map.put(sortedArr[j], rank++);
            }
        }

        // 원래 배열을 압축된 값으로 변환
        for (int k = 0; k < n; k++) {
            arr[k] = map.get(arr[k]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
