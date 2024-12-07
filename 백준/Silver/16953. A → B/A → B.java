import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        Queue<long[]> q = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        q.add(new long[]{A, 0});
        visited.add(A);
        long result = -1;

        while (!q.isEmpty()) {
            long[] arr = q.poll();
            long a = arr[0];
            long num = arr[1];

            if (a == B) {
                result = num + 1;
                break;
            }

            if (a * 2 <= B && !visited.contains(a * 2)) {
                q.add(new long[]{a * 2, num + 1});
                visited.add(a * 2);
            }

            long nextValue = a * 10 + 1;
            if (nextValue <= B && !visited.contains(nextValue)) {
                q.add(new long[]{nextValue, num + 1});
                visited.add(nextValue);
            }
        }
        System.out.println(result);
    }
}
