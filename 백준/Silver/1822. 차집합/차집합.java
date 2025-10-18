import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < nA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < nB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        // 차집합
        List<Integer> result = new ArrayList<>();
        for (int num : setA) {
            if (!setB.contains(num)) {
                result.add(num);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        if (!result.isEmpty()) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
