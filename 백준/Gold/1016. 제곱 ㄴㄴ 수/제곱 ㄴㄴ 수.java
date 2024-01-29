import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    long min = sc.nextLong();
    long max = sc.nextLong();

    boolean[] arr = new boolean[(int)(max - min) + 1];
    
    for(long i = 2; i <= Math.sqrt(max); i++){
        long pow = i * i;
        long idx = min / pow;
        if(min % pow != 0) idx++;
        for(long j = idx; pow * j <= max; j++) arr[(int)((j*pow) - min)] = true;
    }

    int count = 0;
    for(int i = 0; i < arr.length; i++){
        if(!arr[i]) count++;
    }
    System.out.println(count);
}

}
