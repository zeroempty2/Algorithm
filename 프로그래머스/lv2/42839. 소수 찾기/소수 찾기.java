import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> idx = new HashSet<>();
    Set<Integer> use = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    String[] number;
    int answer = 0;
    public int solution(String numbers) {
        number = numbers.split("");
        for (int i = 0; i < number.length; i++) {
            dfs(i);
        }
        return answer;
    }
    private void dfs(int index) {
        if (idx.size() == number.length ) return;
        if (idx.add(index)) sb.append(number[index]);
        else return;
        if (isPrime(Integer.parseInt(sb.toString()))) {
            answer++;
        }
        for ( int i = 0; i < number.length; i++ ) {
            dfs(i);
        }
        if (idx.remove(index)) sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isPrime(int number) {
        if (!use.add(number)) {
            return false;
        }
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}