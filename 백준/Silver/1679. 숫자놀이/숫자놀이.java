import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        HashSet<Integer> numSet = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            numSet.add(nums[i]);
        }

        int k = Integer.parseInt(br.readLine()); // 최대 사용 횟수

        int maxNum = nums[n - 1]; // 가장 큰 숫자
        int maxLen = maxNum * k + 2;

        int[] dp = new int[maxLen];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0; // 0은 만들 필요 없음 (사용하지 않음)

        for (int i = 1; i < maxLen; i++) {
            if (numSet.contains(i)) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= i / 2; j++) {
                    if (dp[j] != Integer.MAX_VALUE && dp[i - j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                    }
                }
            }

            if (dp[i] > k) {
                // 현재 수 i를 만들 수 없음 → 직전까지 만든 사람이 승자
                String winner = (i % 2 == 0) ? "holsoon" : "jjaksoon";
                System.out.println(winner + " win at " + i);
                break;
            }
        }
    }
}
