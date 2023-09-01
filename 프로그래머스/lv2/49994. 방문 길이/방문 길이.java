import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});
        map.put("R", new int[] {1, 0});
        map.put("L", new int[] {-1, 0});

        String[] arr = dirs.split("");

        Set<String> set = new HashSet<>();        
        int cx = 0;
        int cy = 0;

        for(int i=0; i<arr.length; i++) {
            String s = arr[i];

            int x = map.get(s)[0];
            int y = map.get(s)[1];

            cx += x;
            cy += y;

            if(cx < -5 || cx > 5) {
                cx -= x;
                continue;
            }
            if(cy < -5 || cy > 5) {
                cy -= y;
                continue;
            }
            set.add(""+(cx-x)+ ""+ (cy-y)+ ""+cx + ""+cy);
            set.add(""+cx + ""+cy+""+(cx-x)+ ""+ (cy-y));
        } 
        return set.size()/2;
    }
}