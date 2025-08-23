import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next(); 
        sc.close();

        int count = 0;

        while (X.length() > 1) {
            int sum = 0;
            for (char c : X.toCharArray()) {
                sum += c - '0';  
            }
            X = String.valueOf(sum);
            count++;
        }

        System.out.println(count);
        int num = Integer.parseInt(X);
        if (num == 3 || num == 6 || num == 9) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
