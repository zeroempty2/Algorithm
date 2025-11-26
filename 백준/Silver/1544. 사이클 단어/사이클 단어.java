import java.util.*;

public class Main {
    static String normalize(String s) {
        String ss = s + s;
        String best = s;

        for (int i = 1; i < s.length(); i++) {
            String rotated = ss.substring(i, i + s.length());
            if (rotated.compareTo(best) < 0) {
                best = rotated;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String w = sc.next();
            set.add(normalize(w));
        }

        System.out.println(set.size());
    }
}
