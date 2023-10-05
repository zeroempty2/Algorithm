import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        long totalCount = (queue1.length + queue2.length) * 2;

        for(int i = 0; i < queue1.length; i++){
            q1.add((long)queue1[i]);
            sum1 += queue1[i];
            q2.add((long)queue2[i]);
            sum2 += queue2[i];
        }


       while(sum1 != sum2){
        answer++;

        long poll;
        if (sum1 > sum2) {
            poll = q1.poll();
            sum1 -= poll;
            sum2 += poll;
            q2.offer(poll);
        }
         else{
            poll = q2.poll();
            sum1 += poll;
            sum2 -= poll;
            q1.offer(poll);
        }

        if (answer > totalCount) {
            return -1;
        }
        
       }

        return answer;
    }
}