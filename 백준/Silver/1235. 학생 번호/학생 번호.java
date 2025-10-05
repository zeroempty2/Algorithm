import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];

        for (int i = 0; i < N; i++) {
            nums[i] = br.readLine().trim();
        }

        int length = nums[0].length();
        int answer = length;

        for (int k = 1; k <= length; k++) {
            Set<String> set = new HashSet<>();
            for (String num : nums) {
                String suffix = num.substring(length - k);
                set.add(suffix);
            }
            if (set.size() == N) {
                answer = k;
                break;
            }
        }

        System.out.println(answer);
    }
}
