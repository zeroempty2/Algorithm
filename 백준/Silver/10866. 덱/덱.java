import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(x);
            } else if (command.startsWith("push_back")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(x);
            } else if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append('\n');
            } else if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append('\n');
            } else if (command.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
            } else if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
