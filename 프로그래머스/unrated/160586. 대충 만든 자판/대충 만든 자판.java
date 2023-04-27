import java.util.HashMap;
class Solution {
 public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> keys = new HashMap<>();
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                if(keys.containsKey(keymap[i].charAt(j))){
                    if(keys.get(keymap[i].charAt(j)) > j){
                        keys.put(keymap[i].charAt(j),j+1);
                    }
                }
                else{
                    keys.put(keymap[i].charAt(j),j+1);
                }
            }
        }
        for(int k = 0; k < targets.length; k++){
            for(int n = 0; n < targets[k].length(); n++){
                if(keys.containsKey(targets[k].charAt(n))){
                    int key = keys.get(targets[k].charAt(n));
                    answer[k] += key;
                }else{
                    answer[k] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}