import java.util.*;

public class Main {

    static int[] md = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y1=sc.nextInt(), m1=sc.nextInt(), d1=sc.nextInt();
        int y2=sc.nextInt(), m2=sc.nextInt(), d2=sc.nextInt();

        if (y2 > y1 + 1000 ||
            (y2 == y1 + 1000 && (m2 > m1 || (m2 == m1 && d2 >= d1)))) {
            System.out.println("gg");
            return;
        }

        System.out.println("D-" + (toDays(y2,m2,d2) - toDays(y1,m1,d1)));
    }

    static int toDays(int y, int m, int d) {
        int days = 365*(y-1) + (y-1)/4 - (y-1)/100 + (y-1)/400;
        for(int i=1;i<m;i++) days += (i==2 && leap(y)?29:md[i]);
        return days + d;
    }

    static boolean leap(int y) {
        return y%400==0 || (y%4==0 && y%100!=0);
    }
}