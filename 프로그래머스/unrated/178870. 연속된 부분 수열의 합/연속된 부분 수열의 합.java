import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int n = sequence.length;
        List<Pointer> subs = new ArrayList<>();
        while (true){
            if(sum == k) subs.add(new Pointer(left, right));
            if(left == n && right == n) break;
            if(sum <= k && right < n){
                right++;
                if(right < n) sum += sequence[right];
            } else {
                if(left < n) sum -= sequence[left];
                left++;
            }
        }
        subs.sort(Pointer::compareTo);
        return new int[]{subs.get(0).left, subs.get(0).right};
    }
       
    private class Pointer implements Comparable<Pointer>{
        int left;
        int right;
        int size;

        public Pointer(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(Pointer o) {
            if(this.size == o.size) return this.left - o.left;
            return this.size - o.size;
        }
    }
}