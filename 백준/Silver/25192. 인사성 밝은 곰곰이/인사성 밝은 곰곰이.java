import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 처리

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();

            if (line.equals("ENTER")) {
                set.clear(); 
            } else {
                if (!set.contains(line)) {
                    count++;
                    set.add(line);  
                }
            }
        }

        System.out.println(count);
    }
}
