    import java.util.*;

    class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);
            int test = 0;
            for(int i = 0; i < weights.length - 1; i++){
                if(i > 0 && weights[i] == weights[i-1]){
                    test--;
                    answer += test;
                    continue;
                }
                int j = binary(weights, weights[i], i + 1);
                test = 0;
                for(; j > i; j--){
                    if(weights[i] == weights[j] 
                    ||weights[i] * 2== weights[j] 
                    || weights[i] * 3 == weights[j] * 2 
                    || weights[i] * 4 == weights[j] * 3){
                        test++;
                    }
                }
                answer += test;
            }
            return answer;
        }

        public int binary(int[] weights, int num, int i){
            int left = i;
            int right = weights.length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(weights[mid] > num * 2)return mid;
                else left = mid + 1;
            }
            return left;
        }
    }