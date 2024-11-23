import java.util.*;

class Solution {
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    HashMap<String,Integer> map = new HashMap<>();
    int count = 0;
        
    public int solution(String word) {
        int answer = 0;
        
        for(int i=0; i< words.length; i++){
            dfs(String.valueOf(words[i]));
            if(map.containsKey(word)) return map.get(word);
        }    
        
        return answer;
    }
    
    void dfs(String str){
        if(str.length() > 5) return;
        
        if(!map.containsKey(str)){
            count++;
            map.put(str,count);
        } 
    
        for(int i = 0; i < words.length; i++){
            dfs(str + words[i]);
        }
    }
}