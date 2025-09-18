import java.util.*;

public class Main {
    static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    static boolean check(String pw) {
        boolean hasVowel = false;
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (isVowel(c)) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount == 3 || consonantCount == 3) return false;

            if (i > 0 && pw.charAt(i) == pw.charAt(i - 1)) {
                if (!(pw.charAt(i) == 'e' || pw.charAt(i) == 'o')) {
                    return false;
                }
            }
        }

        return hasVowel; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String pw = sc.nextLine();
            if (pw.equals("end")) break;

            if (check(pw)) {
                System.out.println("<" + pw + "> is acceptable.");
            } else {
                System.out.println("<" + pw + "> is not acceptable.");
            }
        }
    }
}
