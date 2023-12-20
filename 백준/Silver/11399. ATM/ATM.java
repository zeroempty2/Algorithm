import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] sum = new int[N];
    for(int i = 0; i < N; i++){
        arr[i] = sc.nextInt();
    }
    sc.close();
    for(int i = 1; i < N; i++){
        int point = i;
        int value = arr[i];
        for(int j = i - 1; j >= 0; j--){
            if(arr[j] < arr[i]){
                point = j + 1;
                break;
            }
            if(j == 0) point = 0;
        }
        for(int j = i; j > point; j--){
            arr[j] = arr[j - 1];
        }
        arr[point] = value;
    }
    sum[0] = arr[0];
    for(int i = 1; i < N; i++){
        sum[i] = sum[i - 1] + arr[i];
    }
    int answer = 0;
    for(int i : sum){
        answer += i;
    }
    System.out.println(answer);
}
}
