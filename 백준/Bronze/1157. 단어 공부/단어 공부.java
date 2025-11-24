import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();  
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'A']++;
        }

        int max = -1;
        char answer = '?';
        int countMax = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                answer = (char) (i + 'A');
                countMax = 1;
            } else if (freq[i] == max) {
                countMax++;
            }
        }

        if (countMax > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }
}
