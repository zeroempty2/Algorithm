import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i < N; i++){
        int pair = sc.nextInt();
        pq.add(pair);
    }
    int pair, sum = 0;
    while(pq.size() > 1){
        pair = pq.poll();
        pair += pq.poll();
        sum += pair;
        pq.add(pair);
    }
    System.out.println(sum);
}

}
