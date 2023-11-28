import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int A = sc.nextInt();
      int B = sc.nextInt();
      sc.close();
      String C = A > B ? ">" : "<";
      if(A == B) C = "==";
      System.out.println(C);
    }
  }