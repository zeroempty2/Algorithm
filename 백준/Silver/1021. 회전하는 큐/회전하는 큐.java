import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int M = sc.nextInt(); 

        LinkedList<Integer> deque = new LinkedList<>();


        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();

            int index = deque.indexOf(target); 
            int halfIndex = deque.size() / 2;

            if (index <= halfIndex) {
                while (deque.getFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                while (deque.getFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst(); 
        }

        System.out.println(count);
    }
}
