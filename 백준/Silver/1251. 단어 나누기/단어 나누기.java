import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String answer = null;

        int len = word.length();

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(word.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(word.substring(j)).reverse().toString();

                String candidate = part1 + part2 + part3;

                if (answer == null || candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        System.out.println(answer);
    }
}
