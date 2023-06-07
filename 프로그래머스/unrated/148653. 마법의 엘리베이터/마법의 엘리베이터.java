import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        int[] initial = new int[] {storey, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(initial);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int score = cur[1];
            int adder = num % 10;
            if(num < 10){
                answer = Math.min(answer, num + score);
                answer = Math.min(answer, score + (10 - num ) + 1);
                continue;
            }

            if(adder == 0){
                q.add(new int []{num / 10, score});
                continue;
            }

            int num1 = (num) / 10;
            q.add(new int[]{num1, score + adder});

            int num2 = num / 10 + 1;
            q.add(new int[]{num2, score + (10 - adder)});

        }
        return answer;
    }
}