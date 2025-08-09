import java.util.*;

public class Main {
    static class Student {
        String name;
        int korean, english, math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            list.add(new Student(name, korean, english, math));
        }

        list.sort((a, b) -> {
            if (a.korean != b.korean) { 
                return b.korean - a.korean;
            } else if (a.english != b.english) { 
                return a.english - b.english;
            } else if (a.math != b.math) { 
                return b.math - a.math;
            } else { 
                return a.name.compareTo(b.name);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.name).append("\n");
        }
        System.out.print(sb);
    }
}
