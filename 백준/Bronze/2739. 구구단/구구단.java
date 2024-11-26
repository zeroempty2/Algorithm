import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      sc.close();
      for(int i = 1; i <= 9; i++){
        int answer = N * i;
        System.out.println(N + " * " + i + " = " + answer);
      }
    }
  }
