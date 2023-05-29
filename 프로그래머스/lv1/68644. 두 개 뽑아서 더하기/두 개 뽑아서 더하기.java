import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                int number = numbers[i]+numbers[j];
                if(!numMap.containsKey(number)){
                    numMap.put(number,number);
                    pq.add(number);
                } 
            }
        }
        while(!pq.isEmpty()){
            answer.add(pq.poll());
        }
        return answer;
    }
}