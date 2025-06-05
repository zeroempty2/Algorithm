import java.util.*;

public class Main {
    static class Question {
        String num;
        int strike, ball;
        Question(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String num = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questions.add(new Question(num, strike, ball));
        }

        int count = 0;

        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);
            if (!isValid(candidate)) continue;

            boolean possible = true;

            for (Question q : questions) {
                int s = getStrike(candidate, q.num);
                int b = getBall(candidate, q.num);
                if (s != q.strike || b != q.ball) {
                    possible = false;
                    break;
                }
            }

            if (possible) count++;
        }

        System.out.println(count);
    }

    static boolean isValid(String num) {
        return num.charAt(0) != num.charAt(1) &&
               num.charAt(1) != num.charAt(2) &&
               num.charAt(0) != num.charAt(2) &&
               !num.contains("0");
    }

    static int getStrike(String a, String b) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (a.charAt(i) == b.charAt(i)) strike++;
        }
        return strike;
    }

    static int getBall(String a, String b) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (a.charAt(i) != b.charAt(i) && b.contains(String.valueOf(a.charAt(i)))) {
                ball++;
            }
        }
        return ball;
    }
}
