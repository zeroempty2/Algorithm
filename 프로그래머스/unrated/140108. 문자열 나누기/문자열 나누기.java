class Solution {
    public int solution(String s) {
    int answer = 0;
    int size = s.length();
    int i = 0;
 
    while(i < size){
        char letter = s.charAt(i);
        int index = 1;
        int index2 = 0;
        while(i + 1 < size && index != index2){
            i++;
            if(s.charAt(i) == letter) index++;
            else index2++;
        }
        answer++;
        i++;
        }
    return answer;
    }   
}
