class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder(); 
        String num = "";
        int say = 0;
        int now = 1;
        int check = 1;

        while(answer.length() < t){
            num = conversion(n, say);

            if(now == p && num.length() == 1){
                answer.append(num);
                say += 1;
            }
            else{
                 if(now == p){
                        String nowNum = num.substring(check - 1, check);
                        answer.append(nowNum);
                    }
                if(check != num.length()){
                    check++;
                }else{
                    check = 1;
                    say += 1;
                }
            }

            if(now == m) now = 1;
            else now++;
            
        }

        return answer.toString().toUpperCase();
    }
    public String conversion(int n, int i){
        return Integer.toString(i,n);
    }
}