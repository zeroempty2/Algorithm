import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(bf.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        while(q.size() > 1){
            q.poll();
            q.add(q.poll()); 
        }
        System.out.println(q.poll());
    }
  }