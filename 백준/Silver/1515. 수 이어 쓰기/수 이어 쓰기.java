import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int tIdx = 0;

        int N = 1;
        while (true) {
            String current = Integer.toString(N);
            for (int i = 0; i < current.length(); i++) {
                if (tIdx < target.length() && current.charAt(i) == target.charAt(tIdx)) {
                    tIdx++;
                    if (tIdx == target.length()) {
                        System.out.println(N);
                        return;
                    }
                }
            }
            N++;
        }
    }
}
