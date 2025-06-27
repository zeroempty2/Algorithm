import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); ) {
            if (i + 2 < str.length() && str.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 3;
            }
            else if (i + 1 < str.length()) {
                String two = str.substring(i, i + 2);
                if (two.equals("c=") || two.equals("c-") ||
                    two.equals("d-") || two.equals("lj") ||
                    two.equals("nj") || two.equals("s=") ||
                    two.equals("z=")) {
                    count++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            }
            // 1글자 처리
            else {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
