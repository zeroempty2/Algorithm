import java.io.*;
import java.util.*;
public class Main {
    static int N;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int[] arr = new int[]{2,3,5,7};
    for(int i : arr) dfs(i, 1);
}
    
static void dfs(int num, int digit){
    if(digit == N){
        if(isPrime(num)){
            System.out.println(num);
        }
        return;
    }

    int nextNum = num * 10;
    for(int i = 1; i < 10; i++){
        if(i % 2 == 0) continue;
        if(isPrime(nextNum + i)){
            dfs(nextNum + i, digit + 1);
        }
    }
    
}

static boolean isPrime(int num){
    for(int i = 2; i <= num / 2; i++){
        if(num % i == 0){
            return false;
        }
    }
    return true;
}
}
