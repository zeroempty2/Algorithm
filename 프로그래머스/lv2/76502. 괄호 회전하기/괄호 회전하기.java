import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        char[] copy = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            Stack<Character> st = new Stack<>();
            copy[arr.length - 1] = arr[0];
            st.push(arr[0]);
            for(int j = 1; j < arr.length; j++){
                copy[j - 1] = arr[j];
                if(st.empty()){
                    st.push(arr[j]);
                    continue;
                }
                if(st.peek() == '{' && arr[j] == '}' || st.peek() == '[' && arr[j] == ']' || st.peek() == '(' && arr[j] == ')'){
                    st.pop();
                }
                else{
                    st.push(arr[j]);
                }
            }
            arr = copy.clone();
            if(st.isEmpty()) answer++;
        }
        return answer;
    }
}