import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    private static long powOfThree(long exponent) {
        long result = 1L;
        for (int i = 0; i < exponent; i++) {
            result *= 3;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long inputNum = Long.parseLong(br.readLine());
        long answer = 0L;

        while (inputNum > 0L) {
            long count = 0L;
            long powerOfTwo = 1L;

            while (inputNum >= powerOfTwo * 2L) {
                powerOfTwo *= 2L;
                count++;
            }

            inputNum -= powerOfTwo; 
            answer += powOfThree(count); 
        }

        System.out.println(answer);
    }
}
