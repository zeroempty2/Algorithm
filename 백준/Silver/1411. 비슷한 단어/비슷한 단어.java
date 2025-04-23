import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Character> mapAtoB = new HashMap<>();
        Map<Character, Character> mapBtoA = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);

            // a -> b로 매핑
            if (!mapAtoB.containsKey(ca)) mapAtoB.put(ca, cb);
            else if (mapAtoB.get(ca) != cb) return false;

            // b -> a로 매핑 (역함수 성립 확인)
            if (!mapBtoA.containsKey(cb)) mapBtoA.put(cb, ca);
            else if (mapBtoA.get(cb) != ca) return false;
        }

        return true;
    }
}
