import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;

                case 2:
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.pop()).append('\n');
                    break;

                case 3:
                    sb.append(stack.size()).append('\n');
                    break;

                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;

                case 5:
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.peek()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
