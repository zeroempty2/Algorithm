import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int F = 1; 

        for (int i = 0; i < N; i++) {  
            int tmp = sc.nextInt(); 

            if (F <= tmp) {
                while (F <= tmp) {
                    st.push(F++);
                    sb.append("+\n");
                }
            }
            
            if (st.isEmpty() || st.peek() != tmp) {
                System.out.println("NO");
                return;
            }
            
            st.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
