import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String N = bf.readLine();
    int[] arr = new int[N.length()];
    for(int i = 0; i < arr.length; i++){
        arr[i] = Integer.parseInt(N.substring(i, i + 1));
    }
    for(int i = 0; i < arr.length; i++){
        int M = i;
        for(int j = i + 1; j < arr.length; j++){
            if(arr[j] > arr[M]) M = j;
        }
        if(arr[i] < arr[M]){
            int tmp = arr[i];
            arr[i] = arr[M];
            arr[M] = tmp;
        }
    }
    for(int a : arr){
        System.out.print(a);
    }
}
}