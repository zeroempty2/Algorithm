import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] freq = new int[8001]; // -4000 ~ 4000을 저장할 수 있는 배열
        int sum = 0, maxFreq = 0, mode = 0;
        boolean secondMode = false; // 두 번째 최빈값을 찾기 위한 플래그

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
            freq[arr[i] + 4000]++; // -4000 ~ 4000을 0 ~ 8000 인덱스로 변환
        }

        Arrays.sort(arr); // 정렬 (중앙값, 범위 계산용)

        // 최빈값 찾기
        for (int i = 0; i < 8001; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mode = i - 4000;
                secondMode = false; // 첫 번째 최빈값이면 초기화
            } else if (freq[i] == maxFreq && !secondMode) {
                mode = i - 4000; // 두 번째로 작은 최빈값 선택
                secondMode = true;
            }
        }


        System.out.println(Math.round((double) sum / N)); // 산술평균
        System.out.println(arr[N / 2]); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(arr[N - 1] - arr[0]); // 범위
    }
}
