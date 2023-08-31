class Solution {
    public long solution(long n) {
        double answer = Math.sqrt((double)n);
        answer = (long) answer * (long) answer < n ? -1 : (answer + 1) * (answer + 1);
        return (long) answer;
    }
}