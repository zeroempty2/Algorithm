import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') totalA++;
        }

        // 문자열을 원형으로 보기 위해 2배로 만듦
        String doubleS = s + s;
        int minSwap = Integer.MAX_VALUE;

        int bCount = 0;
        for (int i = 0; i < totalA; i++) {
            if (doubleS.charAt(i) == 'b') bCount++;
        }
        minSwap = bCount;

        // 슬라이딩 윈도우
        for (int i = totalA; i < doubleS.length(); i++) {
            if (doubleS.charAt(i - totalA) == 'b') bCount--;
            if (doubleS.charAt(i) == 'b') bCount++;
            minSwap = Math.min(minSwap, bCount);
        }

        System.out.println(minSwap);
    }
}
