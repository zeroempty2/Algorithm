import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    boolean[] arr = new boolean[b + 1];

    arr[0] = true;
    arr[1] = true;
    
    for(int i = 2; i <= Math.sqrt(b); i++){
        if(arr[i]) continue;
  
        for(int j = i + i; j < b + 1; j = j + i){
            arr[j] = true;
        }
        
    }

    for(int i = a; i < b + 1; i++){
        if(!arr[i]) System.out.println(i);
    }
}
}
