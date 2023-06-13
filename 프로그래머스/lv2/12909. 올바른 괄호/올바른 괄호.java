import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean solution(String s) {
        return check(s);
    }
    boolean check(String s){
      char[] arr = s.toCharArray();
      if(arr[0] == ')' || arr[arr.length-1] == '(') return false;
      Queue<Character> q = new LinkedList<>();
      for(char c : arr){
        q.add(c);
      }
      int check = 0;
      while(!q.isEmpty()){
        if(check == 0 && q.peek() == ')') return false;
         if(q.peek() == '(') {
          q.poll();
          check++;
         }
         if(q.peek() == ')') {
          q.poll();
          check--;
      }
    }
    if(check != 0) return false;
    return true;
}
}