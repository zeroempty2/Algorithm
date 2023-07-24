import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<Pair>(); 
        for(int i = 0; i < priorities.length; i++){
            q.add(new Pair(priorities[i],i));
        }
        while(!q.isEmpty()){
            boolean check = true;
            Pair p = q.peek();
            for(Pair pair : q){
                int val = p.value;
                if(pair.value > val){
                    check = false;
                    q.add(q.poll());
                    break;
                }
            }
            if(check){
                Pair cp = q.poll();
                answer++;
                if(location == cp.number){
                    break;
                }
            }
        }
        return answer;
    }
}
class Pair {
        int value;
        int number;

        public Pair(int value, int number) {
            this.value = value;
            this.number = number;
        }
    }