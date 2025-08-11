import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        int now = 1; 
        while (!queue.isEmpty()) {
            if (queue.peek() == now) { 
                queue.poll();
                now++;
            } else if (!stack.isEmpty() && stack.peek() == now) { 
                stack.pop();
                now++;
            } else { 
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == now) {
                stack.pop();
                now++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
