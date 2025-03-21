import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{priority, i});
                priorityQueue.add(priority);
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll(); 
                if (front[0] == priorityQueue.peek()) { 
                    priorityQueue.poll();
                    printOrder++;
                    if (front[1] == M) { 
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(front); 
                }
            }
        }
    }
}
