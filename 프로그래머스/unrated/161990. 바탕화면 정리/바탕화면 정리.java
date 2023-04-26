import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int minX = x.get(0);
        int minY = y.get(0);
        int maxX = x.get(0);
        int maxY = y.get(0);
        
        for(int k = 0; k < x.size(); k++){
            if(x.get(k) < minX){
                minX = x.get(k);
            }
            if(x.get(k) > maxX){
                maxX = x.get(k);
            }
            if(y.get(k) < minY){
                minY = y.get(k);
            }
            if(y.get(k) > maxY){
                maxY = y.get(k);
            }
        }

        if(minX == maxX && minY == maxY){
            maxX = minX + 1;
            maxY = minY + 1;
            answer[0] = minX;
            answer[1] = minY;
            answer[2] = maxX;
            answer[3] = maxY;
        }else{
            answer[0] = minX;
            answer[1] = minY;
            answer[2] = maxX + 1;
            answer[3] = maxY + 1;
        }
       
        return answer;
    }
}