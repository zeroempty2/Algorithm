import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            if(x == 0){
                if(pq.size() == 0){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(x);
            }
        }
        sc.close();
      }
}
