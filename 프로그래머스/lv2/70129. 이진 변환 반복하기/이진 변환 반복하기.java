class Solution {
    static int[] answer = new int [2];
    public int[] solution(String s) {
        delete(s);
        return answer;
    }
    public static String delete(String s) {
        if(s.equals("1")) return "";
        int length = s.length();
        for(char zero : s.toCharArray()) {
            if(zero == '0'){
                answer[1]++;
                length--;
            }
                
        }
        answer[0]++;
        return delete(Integer.toString(length,2));
    }
}