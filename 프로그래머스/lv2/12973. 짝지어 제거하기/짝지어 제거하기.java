import java.util.Stack;

class Solution{
    public int solution(String s){
        Stack<Character> st = new Stack<>();
        for(char a : s.toCharArray()){
            if(st.empty()) st.push(a);
            else if(st.peek() == a) st.pop();
            else st.push(a); 
        }
        if(st.empty()) return 1;
        return 0;
    }
}