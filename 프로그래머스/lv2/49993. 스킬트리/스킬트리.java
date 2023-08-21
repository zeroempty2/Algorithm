import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = 0;
        boolean wrong = false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char s : skill.toCharArray()){
            count++;
            map.put(s, count);
        }
        for(String temp : skill_trees){
            count = 1;
            wrong = false;
            char[] skillTree = temp.toCharArray();
            for(int i = 0; i < skillTree.length; i++){
               if(count == skill.length()) break;
               if(map.containsKey(skillTree[i])){
                if(map.get(skillTree[i]) == count){
                    count++;
                }
                else{
                    wrong = true;
                    break;
                }
               }
            }
            if(!wrong) answer++;
        }
        return answer;
    }
}