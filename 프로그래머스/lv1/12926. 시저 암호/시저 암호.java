class Solution {
        public String solution(String s, int n) {
            String answer = "";
            for(char c : s.toCharArray()) {
                if(c ==' ') {
                    answer += c;
                }else if(c >= 'a' && c <= 'z'){
                    answer += (char)('a' + (c + n -'a') % 26);
                }else {
                    answer += (char)('A' + (c + n -'A') % 26);
                }
            }
            return answer;
        }
    }