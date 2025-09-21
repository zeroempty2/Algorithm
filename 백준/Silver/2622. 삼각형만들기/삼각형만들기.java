import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long count = 0;

          for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {   
                int c = n - (a + b);
                if (c < b) continue;         
                if (c <= 0) continue;        
                if (a + b > c) {             
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
