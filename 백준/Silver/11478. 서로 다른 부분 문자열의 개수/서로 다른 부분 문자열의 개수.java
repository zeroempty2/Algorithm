import java.util.*;

public class Main {
    static int lcp(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();
        String[] suffix = new String[n];
        for (int i = 0; i < n; i++) suffix[i] = s.substring(i);
        
        Arrays.sort(suffix);
        
        int answer = suffix[0].length();  

        for (int i = 1; i < n; i++) {
            answer += suffix[i].length() - lcp(suffix[i], suffix[i - 1]);
        }

        System.out.println(answer);
    }
}
