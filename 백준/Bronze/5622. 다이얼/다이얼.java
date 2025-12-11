import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int sum = 0;

        for (char c : s.toCharArray()) {
            if ("ABC".indexOf(c) != -1) sum += 3;
            else if ("DEF".indexOf(c) != -1) sum += 4;
            else if ("GHI".indexOf(c) != -1) sum += 5;
            else if ("JKL".indexOf(c) != -1) sum += 6;
            else if ("MNO".indexOf(c) != -1) sum += 7;
            else if ("PQRS".indexOf(c) != -1) sum += 8;
            else if ("TUV".indexOf(c) != -1) sum += 9;
            else if ("WXYZ".indexOf(c) != -1) sum += 10;
        }

        System.out.println(sum);
    }
}
