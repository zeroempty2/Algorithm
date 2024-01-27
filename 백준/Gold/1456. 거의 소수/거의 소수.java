import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    boolean[] arr = new boolean[10000001];

    arr[0] = true;
    arr[1] = true;
    
    for(int i = 2; i <= Math.sqrt(b); i++){
        if(arr[i]) continue;
  
        for(int j = i + i; j < arr.length; j = j + i){
            arr[j] = true;
        }
        
    }

    long count = 0;
    for(int i = 2; i < 10000001; i++){
        if(!arr[i]){
            long tmp = i;
            while((double)i <= (double)b/tmp){
                if((double)i >= (double)a/tmp){
                    count++;
                }
                tmp *= i;
            }
        }
    }

    System.out.println(count);
}
}
