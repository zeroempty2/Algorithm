import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 누수 지점 개수
        int L = sc.nextInt(); // 테이프 길이
        
        int[] leaks = new int[N];
        for (int i = 0; i < N; i++) {
            leaks[i] = sc.nextInt();
        }
        
        Arrays.sort(leaks); // 누수 지점 정렬
        
        int count = 0;
        double coverEnd = 0; // 현재 테이프로 커버 가능한 끝 위치
        
        for (int i = 0; i < N; i++) {
            if (leaks[i] > coverEnd) {
                count++;
                coverEnd = leaks[i] + L - 0.5; // 새로운 테이프를 붙인 경우 커버 범위 갱신
            }
        }
        
        System.out.println(count);
    }
}
