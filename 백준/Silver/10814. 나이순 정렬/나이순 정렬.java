import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Member(age, name));
        }

        list.sort(Comparator.comparingInt(m -> m.age));

        for (Member m : list) {
            System.out.println(m.age + " " + m.name);
        }

        sc.close();
    }
}
