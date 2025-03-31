import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < T; i++) {
            String ps = sc.nextLine();
            System.out.println(isValidParenthesis(ps) ? "YES" : "NO");
        }

        sc.close();
    }

    public static boolean isValidParenthesis(String ps) {
        Stack<Character> stack = new Stack<>();

        for (char ch : ps.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); 
    }
}
