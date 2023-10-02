import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long temp = k - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (temp == 0) {
                answer[i] = list.get(0);
                list.remove(0);
                continue;
            }
            long factor = factorial(n - i - 1);
            long num = temp / factor;
            answer[i] = list.get((int)num);
            list.remove((int)num);
            temp = temp % factor;
        }

        return answer;
    }

    public long factorial(int n) {
        long factor = 1;
        for (int i = 1; i <= n; i++) {
            factor *= i;
        }
        return factor;
    }
}