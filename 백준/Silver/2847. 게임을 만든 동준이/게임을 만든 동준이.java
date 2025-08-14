import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] levels = new int[N];
        
        for (int i = 0; i < N; i++) {
            levels[i] = sc.nextInt();
        }
        
        int answer = 0;
        
        // 뒤에서 앞으로 확인
        for (int i = N - 2; i >= 0; i--) {
            if (levels[i] >= levels[i + 1]) {
                int newValue = levels[i + 1] - 1;
                answer += (levels[i] - newValue);
                levels[i] = newValue; // 감소 적용
            }
        }
        
        System.out.println(answer);
    }
}
