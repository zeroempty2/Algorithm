import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2) -> {
            int first = Math.abs(i1);
            int second = Math.abs(i2);
            if(first == second) return i1 > i2 ? 1 : -1;
            else return first - second;
        });
        for(int i = 0; i < N; i++){
            int tmp = Integer.valueOf(bf.readLine());
            if(tmp == 0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }
                else{
                    System.out.println(tmp);
                }
            }
            else{
                pq.add(tmp);
            }
        }
    }
  }