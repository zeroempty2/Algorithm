import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(); 
        int h = sc.nextInt(); 

        int n = sc.nextInt(); 

        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        horizontal.add(0);
        horizontal.add(h);
        vertical.add(0);
        vertical.add(w);

        for (int i = 0; i < n; i++) {
            int dir = sc.nextInt();
            int pos = sc.nextInt();

            if (dir == 0) { 
                horizontal.add(pos);
            } else { 
                vertical.add(pos);
            }
        }

        Collections.sort(horizontal);
        Collections.sort(vertical);

        int maxH = 0;
        for (int i = 1; i < horizontal.size(); i++) {
            maxH = Math.max(maxH, horizontal.get(i) - horizontal.get(i - 1));
        }

        int maxW = 0;
        for (int i = 1; i < vertical.size(); i++) {
            maxW = Math.max(maxW, vertical.get(i) - vertical.get(i - 1));
        }

        System.out.println(maxH * maxW);
    }
}
