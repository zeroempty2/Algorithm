class Solution {
    public int solution(int n) {
        int binary = Integer.bitCount(n);
        while(true){
            n++;
            int binaryPlus = Integer.bitCount(n);
            if(binary == binaryPlus) break;
        }
        return n;
    }
}