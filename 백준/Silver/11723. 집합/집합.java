import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int S = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            String action = st.nextToken();
            if (action.equals("all")) S = (1 << 21) - 1;
            else if (action.equals("empty")) S = 0;
            else{
             int num = Integer.parseInt(st.nextToken());
                if (action.equals("add")) S |= (1 << num);  
                else if (action.equals("remove")) S &= ~(1 << num); 
                else if (action.equals("check")) sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if (action.equals("toggle")) S ^= (1 << num);
            }
        }
        System.out.print(sb);
    }
}