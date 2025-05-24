import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong(); // 총 게임 수
        long Y = sc.nextLong(); // 이긴 게임 수
        sc.close();

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            // 승률이 99% 이상이면 절대 승률이 안 변함
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000L;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
