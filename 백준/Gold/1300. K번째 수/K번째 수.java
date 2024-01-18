import java.io.*;
import java.util.*;
public class Main {
    static long answer, start, end = 0;
    static int N,k = 0;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    k = sc.nextInt();
    start = 1L;
    end = (long)k;

    binarySearch();

    System.out.println(answer);
}

static void binarySearch(){
    if(start > end) return;
    long mid = (start + end) / 2;
    long count = 0;
    for(int i = 1; i < N + 1; i++){
        count += Math.min(mid / i, N);
    }
    if(count < k) {
        start = mid + 1;
        binarySearch();
    }
    else{
        answer = mid;
        end = mid - 1;
        binarySearch();
    }
}
}
