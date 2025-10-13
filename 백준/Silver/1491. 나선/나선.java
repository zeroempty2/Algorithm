import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // x축 
        int M = sc.nextInt(); // y축 

        int left = 0, right = N - 1, bottom = 0, top = M - 1;
        int x = 0, y = 0; 
        int dir = 0; 

        while (true) {
            if (dir == 0) { // 동쪽
                if (x < right) x++;
                else {
                    dir = 1; bottom++;
                    if (bottom > top) break;
                    y++;
                }
            } else if (dir == 1) { // 북쪽
                if (y < top) y++;
                else {
                    dir = 2; right--;
                    if (left > right) break;
                    x--;
                }
            } else if (dir == 2) { // 서쪽
                if (x > left) x--;
                else {
                    dir = 3; top--;
                    if (bottom > top) break;
                    y--;
                }
            } else { // 남쪽
                if (y > bottom) y--;
                else {
                    dir = 0; left++;
                    if (left > right) break;
                    x++;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
