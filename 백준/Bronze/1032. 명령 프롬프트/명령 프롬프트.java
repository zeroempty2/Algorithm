import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = sc.next();
        }

        int len = files[0].length();
        StringBuilder pattern = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            char c = files[0].charAt(pos);
            boolean same = true;
            for (int i = 1; i < N; i++) {
                if (files[i].charAt(pos) != c) {
                    same = false;
                    break;
                }
            }
            if (same) {
                pattern.append(c);
            } else {
                pattern.append('?');
            }
        }

        System.out.println(pattern.toString());
    }
}