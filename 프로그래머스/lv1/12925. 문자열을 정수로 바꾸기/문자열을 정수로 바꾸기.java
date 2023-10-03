class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.substring(0, 1).equals("-")){
            answer -= Integer.parseInt(s.substring(1, s.length()));
        }
        else if(s.substring(0, 1).equals("+")){
            answer += Integer.parseInt(s.substring(1, s.length()));
        }
        else{
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}