import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static long result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        bf.close();
        sort(5);
        for(int i : arr){
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void sort(int max){
       int length = arr.length;
       int[] arr2 = new int[length];
       int num = 1;
       int cnt = 0;
       while(cnt != max){
        //자릿수 저장 배열
        int[] arr3 = new int[10];
        for(int i = 0; i < length; i++){
            arr3[(arr[i]/num) % 10]++;
        }
        for(int i = 1; i < 10; i++){
            arr3[i] += arr3[i - 1];
        }
        for(int i = length - 1; i >= 0; i--){
            arr2[arr3[(arr[i]/num) % 10] - 1] = arr[i];
            arr3[(arr[i] / num) % 10]--;
        }
        for(int i = 0; i < length; i++){
            arr[i] = arr2[i];
        }
        num *= 10;
        cnt++;
       }
    }
}
