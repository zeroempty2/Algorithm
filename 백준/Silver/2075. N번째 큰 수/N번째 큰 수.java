import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                pq.offer(num);
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }

        System.out.println(pq.peek()); 
    }
}
