import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int current = N;
        int count = 0;

        while (true) {
            int tens = current / 10;
            int ones = current % 10;
            int sum = tens + ones;

            current = (ones * 10) + (sum % 10);
            count++;

            if (current == N) break;
        }

        System.out.println(count);
    }
}
