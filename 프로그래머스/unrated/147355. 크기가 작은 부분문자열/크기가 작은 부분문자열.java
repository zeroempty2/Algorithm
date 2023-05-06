class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        for(int i = 0; i < t.length(); i++){
            if(i+length > t.length()) break;
            long number = Long.parseLong(t.substring(i,i + length));
            if(number <= Long.parseLong(p)) answer++;
        }
        return answer;
    }  
} 