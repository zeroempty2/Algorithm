import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int M = Integer.parseInt(bf.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(bf.readLine());

    for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
    }    

    Arrays.sort(arr);

    int answer = 0;
    int start = 0;
    int end = N - 1;
    
    while(start < end){
      if(arr[start] + arr[end] < M){
        start++;
        continue;
      }
      if(arr[start] + arr[end] > M){
        end--;
        continue;
      }
      answer++;
      start++;
      end--;
    }
    System.out.println(answer);
}
    
}