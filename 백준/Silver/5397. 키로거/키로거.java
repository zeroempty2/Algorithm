import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '<') {
                    if (!left.empty()) right.push(left.pop());
                } else if (c == '>') {
                    if (!right.empty()) left.push(right.pop());
                } else if (c == '-') {
                    if (!left.empty()) left.pop();
                } else {
                    left.push(c);
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : left) result.append(c);
            while (!right.empty()) result.append(right.pop());

            out.append(result).append("\n");
        }

        System.out.print(out);
    }
}
