import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String expr = sc.next(); // 후위 표기식
        double[] values = new double[26]; // A~Z 대응 값

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double res = 0.0;

                switch (ch) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/': res = a / b; break;
                }
                stack.push(res);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}
