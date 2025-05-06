import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine(); 
        
        char[][] grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        List<String> words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '#') {
                    if (sb.length() >= 2) {
                        words.add(sb.toString());
                    }
                    sb.setLength(0); 
                } else {
                    sb.append(grid[i][j]);
                }
            }
            if (sb.length() >= 2) {
                words.add(sb.toString());
            }
        }

        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                if (grid[i][j] == '#') {
                    if (sb.length() >= 2) {
                        words.add(sb.toString());
                    }
                    sb.setLength(0);
                } else {
                    sb.append(grid[i][j]);
                }
            }
            if (sb.length() >= 2) {
                words.add(sb.toString());
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
