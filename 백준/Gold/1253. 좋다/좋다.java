import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int answer = 0;
    long[] arr = new long[N];

    StringTokenizer st = new StringTokenizer(bf.readLine());

    for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
    }    

    Arrays.sort(arr);
    for(int j = 0; j < N; j++){
      long tmp = arr[j];
      int start = 0;
      int end = N - 1;
    
    while(start < end){
      if(arr[start] + arr[end] < tmp){
        start++;
        continue;
      }
      if(arr[start] + arr[end] > tmp){
        end--;
        continue;
      }
      if(start == j){
        start++;
        continue;
      }
      if(end == j){
        end--;
        continue;
      }
      if(start != j && end != j){
        answer++;
        break;
      }
    }
  }
    System.out.println(answer);
}
    
}