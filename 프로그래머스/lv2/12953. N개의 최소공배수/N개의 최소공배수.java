class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
          for (int num : arr){
            int gcd = num/cal(Math.min(num,answer), Math.max(num,answer));
            answer *= gcd;
          }
        return answer;
    }
    public int cal(int a,int b){
        if(a % b == 0) return b;
        return cal(b,a % b);
    }
}