import java.util.HashMap;

class Solution {
   public String[] solution(String[] players, String[] callings) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      map.put(players[i], i);
    }
    for (String calling : callings){
      int i = map.get(calling);
      players[i] = players[i-1];
      players[i-1] = calling;

      map.put(calling,i-1);
      map.put(players[i],i);
    }
    return players;
  }
}