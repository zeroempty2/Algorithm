class Solution {
    public int solution(int a, int b, int n) {
        int answer = search(a, b, n, 0);
        return answer;
    }
    public int search(int a, int b, int n, int answer){
        if(n == 0 || n / a == 0) return answer;
        int coke = (n / a) * b;
        int emptyCoke = coke + (n % a);
        answer += coke;
        return search(a, b, emptyCoke, answer);
    }
}