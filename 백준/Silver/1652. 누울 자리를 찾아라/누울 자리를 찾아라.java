import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); 

        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            int length = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    length++;
                } else {
                    if (length >= 2) rowCount++;
                    length = 0;
                }
            }
            if (length >= 2) rowCount++; 
        }

        for (int j = 0; j < N; j++) {
            int length = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    length++;
                } else {
                    if (length >= 2) colCount++;
                    length = 0;
                }
            }
            if (length >= 2) colCount++; 
        }

        System.out.println(rowCount + " " + colCount);
    }
}
