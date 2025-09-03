import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        List<BigInteger> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            StringBuilder num = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (Character.isDigit(c)) {
                    num.append(c);
                } else {
                    if (num.length() > 0) {
                        numbers.add(new BigInteger(num.toString()));
                        num.setLength(0);
                    }
                }
            }
            if (num.length() > 0) {
                numbers.add(new BigInteger(num.toString()));
            }
        }

        Collections.sort(numbers);

        for (BigInteger num : numbers) {
            System.out.println(num);
        }
    }
}
