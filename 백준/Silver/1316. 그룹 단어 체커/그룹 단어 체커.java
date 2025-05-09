import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26];
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            // 이전 문자와 다를 경우
            if (curr != prev) {
                if (seen[curr - 'a']) {
                    // 이전에 나왔던 문자가 다시 나타난 경우
                    return false;
                }
                seen[curr - 'a'] = true;
                prev = curr;
            }
        }

        return true;
    }
}
