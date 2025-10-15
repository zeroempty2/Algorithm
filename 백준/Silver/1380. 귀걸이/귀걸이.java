import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scenario = 1;

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            sc.nextLine(); 

            String[] names = new String[n + 1]; 
            for (int i = 1; i <= n; i++) {
                names[i] = sc.nextLine();
            }

            int[] count = new int[n + 1];

            for (int i = 0; i < 2 * n - 1; i++) {
                int num = sc.nextInt();
                String letter = sc.next(); 
                count[num]++; 
            }

            // 한 번만 등장한 번호 찾기
            int missing = -1;
            for (int i = 1; i <= n; i++) {
                if (count[i] == 1) {
                    missing = i;
                    break;
                }
            }

            System.out.println(scenario + " " + names[missing]);
            scenario++;
        }

        sc.close();
    }
}
