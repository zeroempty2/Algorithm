import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int a = 0;
      for(int i = 0; i < 5; i++){
        long b = Long.parseLong(st.nextToken());
        a += b * b;
      }
      System.out.println(a % 10);
    }
  }
