import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());
      for(int i = 0; i < N; i++){
        StringTokenizer s = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(s.nextToken());
        String str =  s.nextToken();
        performance(A,str);
      }
    }

    public static void performance(int repeat, String str){
        String[] arr = str.split("");
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            for(int i = 0; i < repeat; i++){
                sb.append(s);
            }
        }
        System.out.println(sb.toString());
    }
  }
