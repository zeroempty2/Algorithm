import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initial = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 왼쪽, 오른쪽 스택
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기 문자열을 왼쪽 스택에 저장 (커서는 맨 뒤)
        for (char c : initial.toCharArray()) {
            left.push(c);
        }

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char ch = cmd.charAt(2);
                    left.push(ch);
                    break;
            }
        }

        // 결과 문자열 합치기
        StringBuilder sb = new StringBuilder();
        // 왼쪽 스택은 거꾸로 되어 있으므로 다시 뒤집기
        while (!left.isEmpty()) sb.append(left.removeLast());
        while (!right.isEmpty()) sb.append(right.removeFirst());

        bw.write(sb.toString());
        bw.flush();
    }
}
