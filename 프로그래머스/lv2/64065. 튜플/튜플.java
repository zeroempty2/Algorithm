import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        HashSet<Integer> set = new HashSet<>();
        String[] arr = s.split("}");
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            String s1 = arr[i].substring(2, arr[i].length());
            String[] arr2 = s1.split(",");
            for(int j = 0; j < arr2.length; j++){
                int s2 = Integer.valueOf(arr2[j]);
                if(!set.contains(s2)){
                    set.add(s2);
                    answer[i] = s2;
                }else{
                    continue;
                }
            }
        }
        return answer;
    }
}