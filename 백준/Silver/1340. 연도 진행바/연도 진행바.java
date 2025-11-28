import java.util.*;

public class Main {

    static boolean isLeap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine(); 
        String[] parts = line.split(" ");
        String monthStr = parts[0];      
        int day = Integer.parseInt(parts[1].replace(",", ""));   
        int year = Integer.parseInt(parts[2]); 
        String[] hm = parts[3].split(":");   
        int hour = Integer.parseInt(hm[0]);
        int min = Integer.parseInt(hm[1]);

        Map<String, Integer> mm = new HashMap<>();
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        for (int i = 0; i < 12; i++) {
            mm.put(months[i], i + 1);
        }
        int month = mm.get(monthStr);

        int[] md = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (isLeap(year)) md[2] = 29;

        int totalDays = 0;
        for (int i = 1; i <= 12; i++) totalDays += md[i];
        long totalMinutes = (long) totalDays * 24 * 60;

        int passedDays = 0;
        for (int i = 1; i < month; i++) passedDays += md[i];
        passedDays += (day - 1);

        long passedMinutes = (long) passedDays * 24 * 60 + hour * 60 + min;

        System.out.println((double) passedMinutes / totalMinutes * 100);
    }
}
