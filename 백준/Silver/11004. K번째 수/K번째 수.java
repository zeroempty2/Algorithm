import java.io.*;
import java.util.*;
public class Main {
    static int K = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        qSort(0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }
    static void qSort(int a,int b,int k){
        if (b - a < 5000001) {
        Arrays.sort(arr, a, b + 1);
        return;
    }
        if(a < b){
            int p = part(a, b);
            if(p == k) return;
            else if(k < p) qSort(a, p - 1, k);
            else qSort(p + 1, b, k);
        }
    }
    static int part(int a, int b){
        int c = (a + b) / 2;
        swap(a, c);
        int p = arr[a];
        int i = a;
        int j = b;
        while(i < j){
            while(p < arr[j]){
                j--;
            }
            while(i < j && p >= arr[i]){
            i++;
        }
        swap(i, j);
        }
        arr[a] = arr[i];
        arr[i] = p;
        return i;

    }
    static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
