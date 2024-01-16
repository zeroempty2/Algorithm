import java.io.*;
import java.util.*;
public class Main {
    static int[] 대조군;
    static int[] 비교군;
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    대조군 = init(M, st);
    Arrays.sort(대조군);

    st = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    비교군 = init(N, st);

    for(int i : 비교군){
        if(binarySearch(0, M - 1, i)) System.out.println(1);
        else System.out.println(0);
    }

}
static int[] init(int length,StringTokenizer st){
    int[] arr = new int[length];
    for(int i = 0; i < length; i++){
        arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
}

static boolean binarySearch(int left, int right,int 비교값){
    if(left > right) return false;
    int mid = (left + right) / 2;
    int 대조값 = 대조군[mid];
    if(대조값 > 비교값) return binarySearch(left, mid - 1, 비교값);
    else if(대조값 < 비교값) return binarySearch(mid + 1, right, 비교값);
    else return true;
}

}
