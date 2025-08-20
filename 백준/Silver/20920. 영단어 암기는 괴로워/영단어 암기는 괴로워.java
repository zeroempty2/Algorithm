import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            // M 이상인 단어만 저장
            if (word.length() >= M) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // 단어 리스트 생성
        List<String> words = new ArrayList<>(freq.keySet());

        // 정렬 조건 적용
        words.sort((w1, w2) -> {
            int f1 = freq.get(w1);
            int f2 = freq.get(w2);

            if (f1 != f2) return f2 - f1;                //빈도 내림차순
            if (w1.length() != w2.length()) return w2.length() - w1.length(); //길이 내림차순
            return w1.compareTo(w2);                     //사전순 오름차순
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }
        System.out.print(sb);
    }
}
