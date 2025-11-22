import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int r = 0; r < 8; r++) {
            String line = br.readLine();
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 == 0 && line.charAt(c) == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
