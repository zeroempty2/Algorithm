import java.util.Scanner;

public class Main {
    // 분할 정복을 이용한 거듭제곱 계산 함수
    public static long modularExponentiation(long A, long B, long C) {
        if (B == 0) {
            return 1; // B가 0일 경우 항상 결과는 1
        }
        if (B % 2 == 0) { // B가 짝수인 경우
            long half = modularExponentiation(A, B / 2, C);
            return (half * half) % C;
        } else { // B가 홀수인 경우
            return (A * modularExponentiation(A, B - 1, C)) % C;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();

        // 결과 계산 및 출력
        long result = modularExponentiation(A % C, B, C); // A % C로 초기 값 최적화
        System.out.println(result);

        scanner.close();
    }
}
