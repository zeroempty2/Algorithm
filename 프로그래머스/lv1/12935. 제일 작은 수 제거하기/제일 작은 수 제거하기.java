import java.util.*;


class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        if(arr.length == 1){
            answer = new int[]{-1};
            return answer;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
            }

        for(int j = 0; j < arr.length; j++){
            if(arr[j] != min) list.add(arr[j]);
            } 
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}