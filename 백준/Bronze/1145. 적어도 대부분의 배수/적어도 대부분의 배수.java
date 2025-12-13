import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int x = 1;

        while (true) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (x % arr[i] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(x);
                break;
            }
            x++;
        }
    }
}
