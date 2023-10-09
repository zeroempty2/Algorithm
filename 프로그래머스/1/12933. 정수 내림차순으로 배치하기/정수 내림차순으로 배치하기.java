import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder answer = new StringBuilder();
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        for(String i : arr){
            answer.append(i);
        }
        return Long.parseLong(String.valueOf(answer));
    }
}