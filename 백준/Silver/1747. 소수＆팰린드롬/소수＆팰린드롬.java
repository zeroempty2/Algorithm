import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    boolean[] arr = new boolean[10000001];

    arr[0] = true;
    arr[1] = true;
    
    for(int i = 2; i <= Math.sqrt(arr.length); i++){
        if(!arr[i]){
            for(int j = i + i; j < arr.length; j = j + i){
                arr[j] = true;
            }
        }
    }

    int i = n;
    while(true){
        if(!arr[i]){
            if(isPalindrome(i)){
                System.out.println(i);
                break;
            }
        }
        i++;
    }
}
    static boolean isPalindrome(int i){
        char[] arr = String.valueOf(i).toCharArray();
        int s = 0;
        int e = arr.length - 1;
        while(s < e){
            if(arr[s] != arr[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
