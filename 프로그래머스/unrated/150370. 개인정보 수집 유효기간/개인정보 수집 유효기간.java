import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            termsMap.put(terms[i].split(" ")[0],Integer.parseInt(terms[i].split(" ")[1]));
        }
        for(int j = 0; j < privacies.length; j++){
            String privaciesDay = privacies[j].split(" ")[0];
            int preiod = termsMap.get(privacies[j].split(" ")[1]);
            if(isExpire(today, privaciesDay, preiod)){
                answer.add(j + 1);
            } 
        }
      
        return answer;
    }

public boolean isExpire(String today, String privacies, int period){
    String[] todayArray = today.split("\\.");
    String[] privaciesArray = privacies.split("\\.");
    int todayAll = (Integer.parseInt(todayArray[0]) * 336) + (Integer.parseInt(todayArray[1]) * 28) + Integer.parseInt(todayArray[2]);
    int privaciesAll = (Integer.parseInt(privaciesArray[0]) * 336) + (Integer.parseInt(privaciesArray[1]) * 28) + Integer.parseInt(privaciesArray[2]);
    int expriePeriod = 28*period;
    int count = (todayAll - privaciesAll);

    if(count >= expriePeriod){
        return true;
    }else{
        return false;
    }
}
}