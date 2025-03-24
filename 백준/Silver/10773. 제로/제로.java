import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();  // 최근 숫자 제거
            } else {
                stack.push(num);  // 숫자 추가
            }
        }
        
        // 스택에 남아 있는 숫자들의 합 구하기
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
