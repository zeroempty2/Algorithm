import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int index = 0;
        for(int a : A){
            for(int j = index; j < B.length; j++){
                if(a < B[j]){
                    index = j + 1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}