import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> caches = new LinkedList<>();
        if (cacheSize == 0)  return cities.length * 5;
        for (String city : cities) {
            String cityLow = city.toLowerCase();
            if (caches.contains(cityLow)) { 
                caches.remove(cityLow);
                caches.add(cityLow);
                answer++;
            } 
            else {
                if (caches.size() < cacheSize) caches.add(cityLow);
               else { 
                    caches.poll();
                    caches.add(cityLow);
                }
                answer += 5;
            }
        }

        return answer;
    }
}