import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>(); 
        Queue<Integer> q = new LinkedList<>();
        int tp = 0;
        for(int i = 0; i < progresses.length; i++) q.add(ceil(progresses[i], speeds[i]));
        while(!q.isEmpty()) {
                tp = q.poll();
                int count = 1;
                while(!q.isEmpty() && tp >= q.peek()) {
                    q.poll();
                    count++;
                }
                answer.add(count);
            }
        return answer;
    }
    public int ceil(int progress, int speed){
        if((100-progress) % speed != 0) return (100-progress)/speed + 1;
        else return (100-progress)/speed;
    }
}