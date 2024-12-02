import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            String function = bf.readLine();
            int length = Integer.parseInt(bf.readLine());
            String input = bf.readLine();

            Deque<Integer> deque = parseInputToDeque(input);
            boolean isReversed = false;
            boolean error = false;

            for (char c : function.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast(); // 뒤집힌 상태에서는 뒤에서 제거
                    } else {
                        deque.pollFirst(); // 일반 상태에서는 앞에서 제거
                    }
                }
            }

            if (error) continue;

            sb.append("[");
            if (isReversed) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) sb.append(",");
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }

    private static Deque<Integer> parseInputToDeque(String input) {
        Deque<Integer> deque = new ArrayDeque<>();
        String[] tokens = input.replaceAll("[\\[\\]]", "").split(",");

        if (tokens.length == 1 && tokens[0].isEmpty()) {
            return deque; // 빈 입력 처리
        }

        for (String token : tokens) {
            deque.add(Integer.parseInt(token.trim()));
        }
        return deque;
    }
}
