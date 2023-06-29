import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int length = elements.length;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    if (j + k > length - 1) {
                        sum += elements[j + k - length];
                    } else {
                        sum += elements[j + k];
                    }
                }
                set.add(sum);

            }
        }

        return set.size();
    }
}