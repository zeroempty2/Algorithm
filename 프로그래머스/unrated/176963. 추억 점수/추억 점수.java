import java.util.HashMap;

class Solution {
 public int[] solution(String[] name, int[] yearning, String[][] photo) {
    HashMap<String, Integer> map = new HashMap<>();
    int length = photo.length;
    int[] answer = new int[length];
    for (int i = 0; i < name.length; i++) {
      map.put(name[i], yearning[i]);
    }
    for(int j = 0; j < length; j++){
      for(int k = 0; k < photo[j].length; k++){
        try {
          int score = map.get(photo[j][k]);
          answer[j] += score;
        }
        catch (NullPointerException ignored){
        }
      }
    }
    return answer;
  }
}