import java.util.*;

public class Main {
    static int[] daysInMonth = {0,
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y1 = sc.nextInt(), m1 = sc.nextInt(), d1 = sc.nextInt();
        int y2 = sc.nextInt(), m2 = sc.nextInt(), d2 = sc.nextInt();

        if (y2 > y1 + 1000 ||
           (y2 == y1 + 1000 && m2 > m1) ||
           (y2 == y1 + 1000 && m2 == m1 && d2 >= d1)) {
            System.out.println("gg");
            return;
        }

        int startDays = convertToDays(y1, m1, d1);
        int endDays = convertToDays(y2, m2, d2);

        System.out.println("D-" + (endDays - startDays));
    }


    static int convertToDays(int year, int month, int day) {
        int days = 0;

        for (int i = 1; i < year; i++) {
            days += isLeap(i) ? 366 : 365;
        }

        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeap(year)) days += 29;
            else days += daysInMonth[i];
        }

        days += day;

        return days;
    }
    
    static boolean isLeap(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }
}
