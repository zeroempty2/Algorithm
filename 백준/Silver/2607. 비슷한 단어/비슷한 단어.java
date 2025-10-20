import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String first = sc.next();
        int[] base = countLetters(first);
        
        int result = 0;
        for (int i = 1; i < N; i++) {
            String word = sc.next();
            int[] compare = countLetters(word);
            if (isSimilar(base, compare, first.length(), word.length())) {
                result++;
            }
        }
        
        System.out.println(result);
    }

    private static int[] countLetters(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'A']++;
        }
        return count;
    }

    private static boolean isSimilar(int[] base, int[] compare, int lenA, int lenB) {
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(base[i] - compare[i]);
        }

        int lenDiff = Math.abs(lenA - lenB);

        if (diff == 0) return true;           
        if (diff == 1) return true;      
        if (diff == 2 && lenDiff == 0) return true; 
        return false;
    }
}
