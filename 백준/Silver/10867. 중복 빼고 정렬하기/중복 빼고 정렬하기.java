import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
