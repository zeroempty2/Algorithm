import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] switches = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }

        int studentCount = sc.nextInt();

        for (int s = 0; s < studentCount; s++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();

            if (gender == 1) { 
                for (int i = num; i <= n; i += num) {
                    switches[i] ^= 1; // 0->1, 1->0
                }
            } else {
                int left = num, right = num;
                while (left - 1 >= 1 && right + 1 <= n 
                        && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                }
                for (int i = left; i <= right; i++) {
                    switches[i] ^= 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
