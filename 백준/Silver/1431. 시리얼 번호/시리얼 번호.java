import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = sc.nextLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            public int compare(String a, String b) {
                // 1. 길이 짧은 순
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }

                // 2. 자리수 합 작은 순
                int sumA = getDigitSum(a);
                int sumB = getDigitSum(b);
                if (sumA != sumB) {
                    return sumA - sumB;
                }

                // 3. 사전순
                return a.compareTo(b);
            }
        });

        for (String s : serials) {
            System.out.println(s);
        }
    }

    private static int getDigitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
