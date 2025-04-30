import java.util.Scanner;

public class Main {
    // 한수인지 판별하는 함수
    public static boolean isHansu(int num) {
        if (num < 100) return true; // 1~99는 무조건 한수
        int hundreds = num / 100;
        int tens = (num / 10) % 10;
        int ones = num % 10;
        return (hundreds - tens) == (tens - ones); // 등차 수열 판별
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) count++;
        }

        System.out.println(count);
    }
}
