class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            answer[i] = -1;
            for(int j = 1; j <= i ; j++){
                if(arr[i-j] == arr[i]){
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}