class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int a = count(i);
            if(a>limit){
                answer += power;
            }else{
                answer += a;
            }
        }
        return answer;
    }
    public int count(int N){
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }
        return count;
    }
}