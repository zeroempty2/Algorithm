import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        int line = 1;
        int sum = 0;

        // 몇 번째 대각선(line)에 X가 위치하는지 찾기
        while (sum + line < X) {
            sum += line;
            line++;
        }

        int indexInLine = X - sum; // 대각선에서 몇 번째인지

        int numerator;
        int denominator;

        if (line % 2 == 0) {
            // 짝수번째 대각선이면 아래에서 위로
            numerator = indexInLine;
            denominator = line - indexInLine + 1;
        } else {
            // 홀수번째 대각선이면 위에서 아래로
            numerator = line - indexInLine + 1;
            denominator = indexInLine;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
