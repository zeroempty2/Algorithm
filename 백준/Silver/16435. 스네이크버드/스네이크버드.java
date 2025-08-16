import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        int L = sc.nextInt(); 
        int[] fruits = new int[N];
        
        for (int i = 0; i < N; i++) {
            fruits[i] = sc.nextInt();
        }
        
        Arrays.sort(fruits); 
        
        for (int h : fruits) {
            if (h <= L) {
                L++; 
            } else {
                break; 
            }
        }
        
        System.out.println(L);
    }
}
