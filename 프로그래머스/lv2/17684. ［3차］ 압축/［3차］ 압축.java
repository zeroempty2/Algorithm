import java.util.*;

class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    static String indexString = "";
    static int changeIndex;

    public int[] solution(String msg) {
        
        List<Integer> list = new ArrayList<>();

        for(int i = 65; i < 91; i++){
            char alphabet = (char) i;
            map.put(Character.toString(alphabet),i - 64);
        }

        for(int j = 0; j < msg.length(); j++){
            changeIndex = 0;
            indexString = msg.substring(j, j + 1);
            int index = check(j, j + 1, msg);
            String longer = msg.substring(j, index);
            if(!map.containsKey(longer)){
                map.put(longer, map.size() + 1);
            }
            list.add(map.get(indexString));
            int test = map.get(indexString);
            j += changeIndex - j - 1;
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public int check(int w, int c, String msg){
        if(c > msg.length()){
            return c - 1;
        }
        if(map.containsKey(msg.substring(w, c))){
            indexString = msg.substring(w, c);
            changeIndex = c;
            return check(w,c + 1,msg);
        }else{
            return c;
        }
    }
}