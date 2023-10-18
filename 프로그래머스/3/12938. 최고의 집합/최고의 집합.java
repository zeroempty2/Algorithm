class Solution {
    public int[] solution(int n, int s) {
        if(s/n == 0) return new int[]{-1};
        int[] answer = new int[n];
        for(int i = 0; i < answer.length; i++){
            answer[i] = s/n;
            s -= s/n;
            n--;
        }
        return answer;
    }
}