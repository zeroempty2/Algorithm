import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        int digit = 1;
        int start = 1;
        long length = 0;

        while (start * 10 <= N) {
            int end = start * 10 - 1;
            length += (long)(end - start + 1) * digit;
            digit++;
            start *= 10;
        }

        // 마지막 구간 (start 이상 N 이하)
        length += (long)(N - start + 1) * digit;

        System.out.println(length);
    }
}
