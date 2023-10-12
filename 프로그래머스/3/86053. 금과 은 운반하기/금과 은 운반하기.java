class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        return binarySearch(a, b, g, s, w, t);
    }

    public long binarySearch(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long high = 99999999999999999L;
        long low = 0;
        while(low + 1 < high) {
            long mid = (low + high) / 2L;
            if (check(mid, a, b, g, s, w, t)) high = mid;
            else low = mid;
        }
        return high;
    }

    public boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long total = 0;
        long totalGold = 0;
        long totalSilver = 0;

        for (int i = 0; i < g.length; i++) {
            long count = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i]) count++;

            long temp = Math.min(count * w[i], g[i] + s[i]);
            total += temp;
            totalGold += Math.min(temp, g[i]);
            totalSilver += Math.min(temp, s[i]);
        }

        return total >= a+b && totalGold >= a && totalSilver >= b;
    }
}