import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
           map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        for(int j : list){
            k -= j;
            answer++;
            if(k < 1) break;
        }
        return answer;
    }
}