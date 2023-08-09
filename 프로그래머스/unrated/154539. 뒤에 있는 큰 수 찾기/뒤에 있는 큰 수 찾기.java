class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        answer[length - 1] = -1;
        for(int i = length - 2; i >= 0; i--){
            for(int j = i + 1; j < length; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j]; 
                    break;
                }
                else if(numbers[i] >= numbers[j]){
                    if(answer[j] == -1){
                        answer[i] = -1;
                        break;
                    }     
                    else if(numbers[i] < answer[j]){
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}