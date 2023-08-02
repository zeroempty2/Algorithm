import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int crossNum = 0;
        int plusNum = 0;

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length() - 1; i++){
            String sub = str1.substring(i, i + 2);
            if(!Pattern.matches("^[a-zA-Z]*$", sub)) continue;
            String low = sub.toLowerCase();
            map.put(low,map.getOrDefault(low, 0) + 1);
            plusNum++;
        }

        for(int j = 0; j < str2.length() - 1; j++){
            String sub = str2.substring(j, j + 2);
            if(!Pattern.matches("^[a-zA-Z]*$", sub)) continue;
            String low = sub.toLowerCase();
            if(map.containsKey(low)){
                crossNum++;
                map.put(low, map.get(low) - 1);
                if(map.get(low) == 0){
                    map.remove(low);
                }
            }else{
                plusNum++;
            }
        }
        
        if(crossNum == 0 && plusNum == 0){
            return 65536;
        }

        double jaccard = (double)crossNum/plusNum * 65536;

        return (int) jaccard;
    }

}