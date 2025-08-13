import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1: // 앞에 넣기
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2: // 뒤에 넣기
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3: // 앞 빼기
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                    break;
                case 4: // 뒤 빼기
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                    break;
                case 5: // 크기
                    sb.append(deque.size()).append('\n');
                    break;
                case 6: // 비었는지 확인
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7: // 앞 조회
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;
                case 8: // 뒤 조회
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
