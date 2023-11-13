import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = makePair(p);
        return answer;
    }
    private String makePair(String p){
        if(p.equals("")) return p;
        String[] arr = p.split("");
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("(")) left++;
            if(arr[i].equals(")")) right++;
            if(left != 0 && left == right){
                u = p.substring(0,i + 1);
                v = p.substring(i + 1, p.length());
                break;
            } 
        }
        if(correctString(u)) return u + makePair(v);
        else {
            return "(" + makePair(v) + ")" + fixPair(u);
        }
    }

    private String fixPair(String u){
        StringBuilder stringBuilder = new StringBuilder();
        
        for(int i = 1; i < u.length() - 1; i++){
            char ch = u.charAt(i);
            if(ch == '(') stringBuilder.append(')');
            else stringBuilder.append('(');
        }
        return stringBuilder.toString();
    }

        public boolean correctString(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}