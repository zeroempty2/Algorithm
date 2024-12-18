import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
          int x = Integer.parseInt(bf.readLine());
          if(x == 0){
            if(!pq.isEmpty()){
              sb.append(String.valueOf(pq.poll())).append("\n");
            } 
            else{
              sb.append("0").append("\n");
            }
            continue; 
          } 
          pq.add(x);
        }
        System.out.println(sb);
      }
}
