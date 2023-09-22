import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 1;
        int stack = 1;
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int number : order){
            q.add(number);
        }
        st.add(1);
        while(!q.isEmpty()){
            if(q.peek() == idx){
                q.poll();
                st.pop();
                answer++;
                if(!st.isEmpty()) idx = st.peek();
                else idx = -1;
            }
            else if(idx > order.length) break;
            else if(idx > q.peek()) break;
            else{
                stack++;
                st.add(stack);
                idx = stack;
            }

        }
        
        return answer;
    }
}