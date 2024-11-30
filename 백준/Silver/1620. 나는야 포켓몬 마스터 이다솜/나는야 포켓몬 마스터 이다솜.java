import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> word = new HashMap<>();
        HashMap<Integer,String> num = new HashMap<>();

        for(int i = 1; i < N+1; i++){
          String pkMon = bf.readLine();
          word.put(pkMon,i);
          num.put(i, pkMon);
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < M; j++){
          String ex = bf.readLine();

          if(isNumeric(ex)){
            sb.append(num.get(Integer.parseInt(ex))).append("\n");
          }
          else{
            sb.append(word.get(ex)).append("\n");
          }
        }
        
        System.out.println(sb);
         
      }

      public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);  
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
     
}
