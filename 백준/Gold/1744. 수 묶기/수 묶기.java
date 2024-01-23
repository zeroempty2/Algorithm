import java.io.*;
import java.util.*;
public class Main {
    static int answer = 0;
    static int one,zero = 0;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    PriorityQueue<Integer> amniotic = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> negative = new PriorityQueue<>();

    for(int i = 0; i < N; i++){
        int num = sc.nextInt();
        if(num < 0) negative.add(num);
        else if(num > 1) amniotic.add(num);
        else if(num == 1) one++;
        else if(num == 0) zero++;
    }

    if(!amniotic.isEmpty()) cal(amniotic);
    if(!negative.isEmpty()) cal(negative);

    System.out.println(answer + one);
}

static void cal(PriorityQueue<Integer> pq){
    boolean isNegative = pq.peek() < 0;

    while(pq.size() > 1) answer += pq.poll() * pq.poll();

    if(!pq.isEmpty()){
        if(isNegative && zero != 0) return;
        answer += pq.poll();
    } 
}

}
