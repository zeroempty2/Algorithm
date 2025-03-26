import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String L = sc.next();
        String R = sc.next();
        
        // L과 R의 길이가 다르면 8이 최소인 수는 0개
        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int minCount = Integer.MAX_VALUE; // 최소 8 개수
        int count = 0;
        
        // 자릿수 비교
        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) != R.charAt(i)) break; 
            if (L.charAt(i) == '8') count++; // 같은 숫자인 경우 8을 카운트
        }
        
        System.out.println(count);
    }
}
