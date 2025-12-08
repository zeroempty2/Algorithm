import java.util.Scanner;

public class Main {

    static int cmp(String a, String b) {
        if (a.length() != b.length()) return a.length() < b.length() ? -1 : 1;
        return a.compareTo(b);
    }

    static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0 ? a.charAt(i--) - '0' : 0);
            int y = (j >= 0 ? b.charAt(j--) - '0' : 0);
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    static String sub(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, borrow = 0;

        while (i >= 0) {
            int x = a.charAt(i--) - '0';
            int y = (j >= 0 ? b.charAt(j--) - '0' : 0);
            int val = x - y - borrow;

            if (val < 0) {
                val += 10;
                borrow = 1;
            } else borrow = 0;

            sb.append(val);
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }

    static String mul(String a, String b) {
        int n = a.length(), m = b.length();
        int[] arr = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                mul += arr[i + j + 1];
                arr[i + j + 1] = mul % 10;
                arr[i + j] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x);

        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

    static String mid(String a, String b) {
        // mid = (a + b) / 2
        String sum = add(a, b);

        // sum / 2
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < sum.length(); i++) {
            int cur = carry * 10 + (sum.charAt(i) - '0');
            sb.append(cur / 2);
            carry = cur % 2;
        }

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }

    static String pow10(int k) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 0; i < k; i++) sb.append("0");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int len = N.length();
        int maxLen = (len + 1) / 2;

        String left = "0";
        String right = pow10(maxLen);  
        String ans = "0";

        while (cmp(left, right) <= 0) {
            String mid = mid(left, right);
            String sq = mul(mid, mid);

            int c = cmp(sq, N);

            if (c == 0) {
                ans = mid;
                break;
            } else if (c < 0) {
                ans = mid;
                left = add(mid, "1");
            } else {
                right = sub(mid, "1");
            }
        }

        System.out.println(ans);
    }
}
