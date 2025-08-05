import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int len = S.length();
        String[] suffixes = new String[len];

        for (int i = 0; i < len; i++) {
            suffixes[i] = S.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suf : suffixes) {
            System.out.println(suf);
        }
    }
}
