class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String nNumber = Integer.toString(n,k);
        String[] numbers = nNumber.split("0");
        for(String number : numbers){
            if(!number.matches("[0-9.]+")) continue;
            long num = Long.parseLong(number);
            if(num == 1) continue;
            if(primeNumber(num) || num == 2) answer++;
        }
        return answer;
    }
    public boolean primeNumber(long num){
        for(int i = 2; i < Math.sqrt(num) + 1; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}