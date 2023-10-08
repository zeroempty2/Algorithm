public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] arr = String.valueOf(n).split("");
        for(String i : arr){
            answer += Integer.valueOf(i);
        }
        return answer;
    }
}