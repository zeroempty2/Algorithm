import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int starCount = 0;
        Queue<Character> numberQ = new LinkedList<>();
        Stack<String> st = new Stack<>();

        for(char i : dartResult.toCharArray()){
          if(i == 'S' || i == 'D' || i == 'T'){
            char[] charArr = new char[numberQ.size()];
            int index = 0;
            while(!numberQ.isEmpty()){
                charArr[index] = numberQ.poll();
                index++;
            }
            String num = String.valueOf(charArr);
            st.add(cal(num, i));
            continue;
            }
            if(i == '#') {
                st.add("#");
                continue;
            }
            if(i == '*'){
                st.add("*");
                continue;
            }
            numberQ.add(i);
        }

        while(!st.empty()){
            String pop = st.pop();
            if(pop.equals("#")){
                String num = st.pop();
                    int minus = Integer.valueOf(num) * -1;
                if(starCount > 0){
                    minus = Integer.valueOf(num) * -2;
                    starCount--;
                }
                answer += minus;
                continue;
            }
            if(pop.equals("*")){
                int star = Integer.valueOf(st.pop()) * 2;
                if(starCount > 0){
                    star = star * 2;
                    starCount--;
                }
                starCount += 1;
                answer += star;
                continue;
            }
            if(starCount > 0){
                answer += Integer.valueOf(pop) * 2;
                starCount--;
                continue;
            }
            answer += Integer.valueOf(pop);
        }

        return answer;
    }

    public String cal(String num, char sqr){
        int number = Integer.valueOf(num);
        int i = 0;
        if(sqr == 'S') i = 1;
        if(sqr == 'D') i = 2;
        if(sqr == 'T') i = 3;
        double square = Math.pow((double)number,i);
        return String.valueOf((int) square);
    }
}