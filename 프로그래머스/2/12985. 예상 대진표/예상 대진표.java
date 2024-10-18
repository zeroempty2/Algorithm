class Solution {
    public int solution(int n, int a, int b) {
        return match(a, b, 1);
    }

    public int match(int a, int b, int count) {
        if (Math.abs(a - b) == 1) return count;
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        count++;
        return match(a, b, count);
    }
}