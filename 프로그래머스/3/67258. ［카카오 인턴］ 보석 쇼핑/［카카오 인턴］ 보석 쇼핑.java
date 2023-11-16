import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
    
class Solution {
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int length = Integer.MAX_VALUE;
        int start = 0;

        for(String gem : gems) set.add(gem);
    
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1); 

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == set.size() && length > (end - start)) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
 
        return answer;
    }
  
}