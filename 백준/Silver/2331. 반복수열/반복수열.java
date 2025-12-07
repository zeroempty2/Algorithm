import java.io.*;
import java.util.*;

public class Main {
    static int A, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 등장 위치 저장 (값 → 몇 번째로 등장했는지)
        Map<Integer, Integer> visited = new HashMap<>();

        int index = 1;
        int current = A;
        visited.put(current, index);

        while (true) {
            index++;
            int next = nextNumber(current);

            if (visited.containsKey(next)) {
                // 사이클 시작 위치가 곧 "반복되는 부분 제외" 길이
                int cycleStart = visited.get(next) - 1;
                System.out.println(cycleStart);
                return;
            }

            visited.put(next, index);
            current = next;
        }
    }

    static int nextNumber(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += Math.pow(digit, P);
            x /= 10;
        }
        return sum;
    }
}
