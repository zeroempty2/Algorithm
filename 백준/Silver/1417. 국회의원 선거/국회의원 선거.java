import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int dasom = sc.nextInt(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < N; i++) {
            pq.add(sc.nextInt());
        }
        
        int bribe = 0;

        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int top = pq.poll(); 
            top--;               
            dasom++;            
            bribe++;            
            pq.add(top);        
        }
        
        System.out.println(bribe);
    }
}
