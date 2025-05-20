import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aSize = sc.nextInt();
        int bSize = sc.nextInt();

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < aSize; i++) {
            setA.add(sc.nextInt());
        }
 
        for (int i = 0; i < bSize; i++) {
            setB.add(sc.nextInt());
        }

        // A - B 계산
        Set<Integer> diffAB = new HashSet<>(setA);
        diffAB.removeAll(setB);

        // B - A 계산
        Set<Integer> diffBA = new HashSet<>(setB);
        diffBA.removeAll(setA);

        // 대칭 차집합 크기 출력
        System.out.println(diffAB.size() + diffBA.size());
    }
}
