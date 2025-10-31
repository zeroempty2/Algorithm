import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (dancing.contains(a) || dancing.contains(b)) {
                dancing.add(a);
                dancing.add(b);
            }
        }

        System.out.println(dancing.size());
    }
}
