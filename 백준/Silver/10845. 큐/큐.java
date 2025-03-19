import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        Queue<Integer> queue = new LinkedList<>();
        
        int N = Integer.parseInt(bf.readLine()); 

        for (int i = 0; i < N; i++) {
            String command = bf.readLine(); 

            if (command.startsWith("push")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                queue.offer(X);
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? "-1" : queue.toArray()[queue.size() - 1]).append("\n");
            }
        }
        System.out.print(sb); 
    }
}
