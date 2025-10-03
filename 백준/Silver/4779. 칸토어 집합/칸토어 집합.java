import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] line;

    public static void cantor(int start, int length) {
        if (length == 1) return;  
        int third = length / 3;
        for (int i = start + third; i < start + 2 * third; i++) {
            line[i] = ' ';
        }

        cantor(start, third);
        cantor(start + 2 * third, third);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int N = Integer.parseInt(input);
            int length = (int) Math.pow(3, N);

            line = new char[length];
            for (int i = 0; i < length; i++) {
                line[i] = '-';
            }

            cantor(0, length);
            System.out.println(new String(line));
        }
    }
}
