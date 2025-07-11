import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String room = sc.next();
        int[] count = new int[10];

        for (char ch : room.toCharArray()) {
            int digit = ch - '0';
            count[digit]++;
        }

        int sixNine = count[6] + count[9];
        count[6] = count[9] = (sixNine + 1) / 2;

        int max = 0;
        for (int c : count) {
            if (c > max) max = c;
        }

        System.out.println(max);
    }
}