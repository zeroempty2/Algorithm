import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int J = Integer.parseInt(br.readLine()); 

        int start = 1;       
        int end = M;         
        int move = 0;        

        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine()); 

            if (pos < start) {          
                int dist = start - pos;
                move += dist;
                start -= dist;
                end -= dist;
            } else if (pos > end) { 
                int dist = pos - end;
                move += dist;
                start += dist;
                end += dist;
            }
        }

        System.out.println(move);
    }
}
