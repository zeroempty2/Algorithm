import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] seen = new boolean[42]; // 나머지는 0~41
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int r = num % 42;
            
            if (!seen[r]) {
                seen[r] = true;
                count++;
            }
        }

        System.out.println(count);
    }
}
