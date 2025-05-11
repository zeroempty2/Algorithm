import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int count0 = 0;
        int count1 = 0; 
        
        char prev = S.charAt(0);
        if (prev == '0') count0++;
        else count1++;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != prev) {
                if (S.charAt(i) == '0') count0++;
                else count1++;
                prev = S.charAt(i);
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
