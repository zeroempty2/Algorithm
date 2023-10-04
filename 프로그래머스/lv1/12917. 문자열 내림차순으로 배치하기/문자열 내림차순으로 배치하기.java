import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Integer[] arr = new Integer[s.length()];
        char[] sArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            arr[i] = (int)sArr[i];
        }

        Arrays.sort(arr, (i1, i2) -> i2 - i1);

        for(int j : arr){
            answer.append((char)j);
        }
        return answer.toString();
    }
}