import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(bf.readLine());
    long answer = n;
    for(long i = 2; i <= Math.sqrt(n); i++){
        if(n % i == 0){
            answer -= answer/i;
            while(n % i == 0) n /= i;
        }
    }
    if(n > 1) answer -= answer/n;
    System.out.println(answer);
}
}
