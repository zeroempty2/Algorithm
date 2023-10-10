import java.util.*;

class Solution {
     int answer = Integer.MAX_VALUE;
     int[][] pick = {{1,1,1},{5,1,1},{25,5,1}};
     HashMap<String,Integer> mineralNum = new HashMap<>();
     int[] use;
     int totalPicks = 0;
    public int solution(int[] picks, String[] minerals) {
        mineralNum.put("diamond", 0);
        mineralNum.put("iron", 1);
        mineralNum.put("stone", 2);

        use = new int[picks.length];
        
        for(int pick : picks) totalPicks += pick;
       
        for(int i = 0; i < picks.length; i++){
            if (picks[i] == use[i]) {
                continue;
            }
            use[i]++;
            mine(picks, minerals, 0, i, 0, 1);
            use[i]--;
        }
        
        return answer;
    }
    public void mine(int[] picks, String[] minerals, int mineralIndex, int pickIndex, int tired, int count){
        if (mineralIndex >= minerals.length) {
            return;
        } 
        int spend = 0;

        for (int i = mineralIndex; i < mineralIndex + 5; i++) {
            if (i >= minerals.length) {
                break;
            }
            spend += pick[pickIndex][mineralNum.get(minerals[i])];
        }

        if (count >= totalPicks || mineralIndex + 5 >= minerals.length) {
            answer = Math.min(answer, tired + spend);
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0 || picks[i] == use[i]) {
                continue;
            }
 
            use[i]++;
            mine(picks, minerals, mineralIndex + 5, i, tired + spend, count + 1);
            use[i]--;
        }
        }
    }
