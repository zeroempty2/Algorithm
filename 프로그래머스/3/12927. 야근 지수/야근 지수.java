import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) pq.add(work);
        for(int i = 0; i < n; i++){
            int work = pq.poll();
            if(work == 0) return 0;
            pq.add(work - 1);
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}