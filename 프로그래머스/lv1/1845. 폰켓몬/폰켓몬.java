import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, i);
        answer = map.size() > n ? n : map.size();
        return answer;
    }
}