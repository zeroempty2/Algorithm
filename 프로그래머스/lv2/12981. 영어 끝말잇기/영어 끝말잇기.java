import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            String word1 = words[i].substring(0, 1);
            String word2 = words[i-1].substring(words[i-1].length() - 1, words[i-1].length());
            if(!word1.equals(word2) || set.contains(words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            set.add(words[i]);
        }
        return answer;
    }
}