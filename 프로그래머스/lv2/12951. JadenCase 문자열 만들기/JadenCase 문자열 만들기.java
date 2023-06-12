class Solution {
  public String solution(String s) {
        String answer = "";
        
        String[] sArray = s.toLowerCase().split("");
        boolean first = true;

        for(String str : sArray) {
            answer += first ? str.toUpperCase() : str;
            first = str.equals(" ") ? true : false;
        }
        return answer;
  }
}