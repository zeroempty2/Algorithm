import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();              
        int[] a = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            set.add(a[i]);
        }

        int x = sc.nextInt();             
        int count = 0;

        for (int i = 0; i < n; i++) {
            int target = x - a[i];
            if (set.contains(target) && target != a[i]) {
                count++;
                set.remove(a[i]);
                set.remove(target);
            }
        }

        System.out.println(count);
    }
}
