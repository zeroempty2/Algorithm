import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        String pattern = sc.next(); 


        String[] parts = pattern.split("\\*");
        String prefix = parts[0];
        String suffix = parts[1];

        for (int i = 0; i < N; i++) {
            String filename = sc.next();

            if (filename.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
                continue;
            }

            if (filename.startsWith(prefix) && filename.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
