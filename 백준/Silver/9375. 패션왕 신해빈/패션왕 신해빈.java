import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine()); // 의상의 개수
            HashMap<String, List<String>> map = new HashMap<>(); 

            // 의상 정보 입력 처리
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String wearing = st.nextToken(); // 의상 이름 
                String wear = st.nextToken();   // 의상 종류

                // 종류별로 리스트에 추가
                map.putIfAbsent(wear, new ArrayList<>());
                map.get(wear).add(wearing);
            }

            // 경우의 수 계산
            int result = 1;
            for (String key : map.keySet()) {
                int num = map.get(key).size(); // 해당 종류의 의상 개수
                result *= (num + 1);          // 의상을 입지 않는 경우까지 포함
            }

            // 아무것도 입지 않은 상태 제외
            sb.append(String.valueOf(result - 1)).append("\n");

        }
        System.out.println(sb);
    }
}
