import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();


        for(int i = 1; i < N+1; i++){
          st = new StringTokenizer(bf.readLine());
          String site = st.nextToken();
          String password = st.nextToken();
          map.put(site, password);
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < M; j++){
          String ex = bf.readLine();

          sb.append(map.get(ex)).append("\n");
        }
        
        System.out.println(sb);
         
      }
     
}
