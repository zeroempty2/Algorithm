import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.valueOf(bf.readLine());
    int[] answer = new int[N];
    int[] arr = Arrays.stream(bf.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
    Stack<Integer> st = new Stack<>();
    Arrays.fill(answer,-1);
    st.push(0);
    for(int i = 1; i < N; i++){
      while(!st.isEmpty() && arr[st.peek()] < arr[i]){
        answer[st.pop()] = arr[i];
      }
      st.push(i);
    }
    for(int i = 0; i < N; i++){
      bw.write(answer[i] + " ");
    }
    bw.write("\n");
    bw.flush();
}
}
