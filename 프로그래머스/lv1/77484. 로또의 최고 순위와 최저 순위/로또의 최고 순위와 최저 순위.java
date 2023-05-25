    import java.util.HashMap;

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[]{6,6};
            int collect = 0;
            int zero = 0;
            int count = 1;
            HashMap<Integer,Integer> winMap = new HashMap<>();
            for(int i : win_nums){
                winMap.put(i, i);
            }
            for(int j : lottos){
                if(winMap.containsKey(j)) collect++;
                if(j == 0) zero++;
            }
            for(int k = 6; k > 0; k--){
                if(collect + zero == k) answer[0] = count;
                if (collect == k) answer[1] = count;
                count++;
            }
            return answer;
        }
    }