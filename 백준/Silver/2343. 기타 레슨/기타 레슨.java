import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int M;
    static int start = 0;
    static int end = 0;
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(bf.readLine());

    for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        if(start < arr[i]) start = arr[i];
        end += arr[i];
    }

    binarySearch();

    System.out.println(start);
}

static void binarySearch(){
    if(start > end) return;
    int mid = (start + end) / 2;
    int sum = 0;
    int count = 0;
    for(int i : arr){
        if(sum + i > mid){
            count++;
            sum = 0;
        }
        sum += i;
    }
    if(sum != 0) count++;
    if(count > M) {
        start = mid + 1;
        binarySearch();
    }
    else{
        end = mid - 1;
        binarySearch();
    }
}
}
