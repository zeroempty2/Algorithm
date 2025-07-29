import java.util.*;

class Person {
    String name;
    int day, month, year;

    Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int dd = sc.nextInt();
            int mm = sc.nextInt();
            int yyyy = sc.nextInt();
            list.add(new Person(name, dd, mm, yyyy));
        }

        list.sort((a, b) -> {
            if (a.year != b.year) return Integer.compare(a.year, b.year);
            if (a.month != b.month) return Integer.compare(a.month, b.month);
            return Integer.compare(a.day, b.day);
        });

        System.out.println(list.get(list.size() - 1).name);
        System.out.println(list.get(0).name); 
    }
}
