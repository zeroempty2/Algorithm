import java.io.*;
import java.util.*;
public class Main {
    static int N,k = 0;
    static int[] arr;
    static int count = 0;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    k = sc.nextInt();
    arr = new int[N];
    for(int i = 0; i < N; i++){
        arr[i] = sc.nextInt();
    }
    cal(N - 1);
    System.out.println(count);
}

 static void cal(int index){
    if(k < 0 || index < 0) return;
    if(arr[index] <= k){
        count += k/arr[index];
        k %= arr[index];
        cal(index - 1);
    }
    else{
        cal(index - 1);
    } 
 }
}
