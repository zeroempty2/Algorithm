import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        char[] digits = N.toCharArray();
        int sum = 0;
        boolean hasZero = false;

        for (char c : digits) {
            int d = c - '0';
            sum += d;
            if (d == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.println(sb.reverse().toString());
    }
}
