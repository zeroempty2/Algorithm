import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Long> num = new ArrayList<>();
    List<String> cal = new ArrayList<>();
    long answer = 0L;

    public long solution(String expression) {
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
            case '*':
                cal.add(String.valueOf(expression.charAt(i)));
                num.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
                break;
            case '+':
                cal.add(String.valueOf(expression.charAt(i)));
                num.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
                break;
            case '-':
                cal.add(String.valueOf(expression.charAt(i)));
                num.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
                break;
            }
        }
        num.add(Long.parseLong(expression.substring(idx, expression.length())));

        cal("*","+","-",1);
        return answer;
    }

    private void cal(String first, String second, String third,int count){
        if(count > 9) return;
        long result = 0;

        int idx = 0;
        List<Long> tempNum = new ArrayList<>(num);
        List<String> tempCal = new ArrayList<>(cal);
        while (!tempCal.isEmpty()) {
            if (tempCal.indexOf(first) != -1)
                idx = tempCal.indexOf(first);
            else if (tempCal.indexOf(second) != -1)
                idx = tempCal.indexOf(second);
            else
                idx = tempCal.indexOf(third);

            if(idx == -1) break;

            long f = tempNum.remove(idx);
            long e = tempNum.remove(idx);
            String c = tempCal.remove(idx);

            switch (c) {
            case "*":
                result = f * e;
                break;
            case "+":
                result = f + e;
                break;
            case "-":
                result = f - e;
                break;
            }
            tempNum.add(idx, result);
        }
       if(result < 0) result *= -1;
       answer = Math.max(result, answer);
       cal(second, first, third ,count + 1);
       cal(third, second, first, count + 1);
    }
}