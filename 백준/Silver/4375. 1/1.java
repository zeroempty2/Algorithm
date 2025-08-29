import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int remainder = 1 % n; 
            int length = 1;
            
            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n; 
                length++;
            }
            
            System.out.println(length);
        }
        
        sc.close();
    }
}
