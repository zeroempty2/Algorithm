import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] people = new int[N][2]; 
        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
            ranks[i] = 1; 
        }
   
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) { 
                    if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                        ranks[i]++; 
                    }
                }
            }
        }
        
        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
