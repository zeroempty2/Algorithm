class Solution {
    public String solution(String s) {
        String[] array = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
           int num = Integer.valueOf(array[i]);
            min = num < min ? num : min;
            max = num > max ? num : max;
        }
        String answer = min + " " + max;
        return answer;
    }
}