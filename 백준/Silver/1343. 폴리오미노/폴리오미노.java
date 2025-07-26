import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.nextLine();

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < board.length()) {
            if (board.charAt(i) == 'X') {
                int count = 0;
                while (i < board.length() && board.charAt(i) == 'X') {
                    count++;
                    i++;
                }

                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                while (count >= 4) {
                    result.append("AAAA");
                    count -= 4;
                }
                if (count == 2) {
                    result.append("BB");
                }
            } else {
                result.append('.');
                i++;
            }
        }

        System.out.println(result);
    }
}
