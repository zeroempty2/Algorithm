import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong(); 
        int result = (int)Math.sqrt(N);

        System.out.println(result);
    }
}
